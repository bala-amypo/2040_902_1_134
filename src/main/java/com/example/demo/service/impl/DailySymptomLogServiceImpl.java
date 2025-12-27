package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {
    
    private final DailySymptomLogRepository dailySymptomLogRepository;
    private final PatientProfileRepository patientProfileRepository;
    private final RecoveryCurveService recoveryCurveService;
    private final DeviationRuleService deviationRuleService;
    private final ClinicalAlertRecordRepository clinicalAlertRecordRepository;
    
    public DailySymptomLogServiceImpl(DailySymptomLogRepository dailySymptomLogRepository,
                                    PatientProfileRepository patientProfileRepository,
                                    RecoveryCurveService recoveryCurveService,
                                    DeviationRuleService deviationRuleService,
                                    ClinicalAlertRecordRepository clinicalAlertRecordRepository) {
        this.dailySymptomLogRepository = dailySymptomLogRepository;
        this.patientProfileRepository = patientProfileRepository;
        this.recoveryCurveService = recoveryCurveService;
        this.deviationRuleService = deviationRuleService;
        this.clinicalAlertRecordRepository = clinicalAlertRecordRepository;
    }
    
    @Override
    public DailySymptomLog recordSymptomLog(DailySymptomLog log) {
        PatientProfile patient = patientProfileRepository.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        
        if (dailySymptomLogRepository.findByPatientIdAndLogDate(log.getPatientId(), log.getLogDate()).isPresent()) {
            throw new IllegalArgumentException("Log already exists for this date");
        }
        
        DailySymptomLog saved = dailySymptomLogRepository.save(log);
        checkForAlerts(saved, patient);
        return saved;
    }
    
    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {
        patientProfileRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        return dailySymptomLogRepository.findByPatientId(patientId);
    }
    
    @Override
    public DailySymptomLog updateSymptomLog(Long id, DailySymptomLog log) {
        DailySymptomLog existing = dailySymptomLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));

        PatientProfile patient = patientProfileRepository.findById(log.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        existing.setPatientId(log.getPatientId());
        existing.setLogDate(log.getLogDate());
        existing.setPainLevel(log.getPainLevel());
        existing.setMobilityLevel(log.getMobilityLevel());
        existing.setFatigueLevel(log.getFatigueLevel());
        existing.setAdditionalNotes(log.getAdditionalNotes());

        return dailySymptomLogRepository.save(existing);
    }
    
    private void checkForAlerts(DailySymptomLog log, PatientProfile patient) {
        long daysSinceSurgery = ChronoUnit.DAYS.between(patient.getCreatedAt().toLocalDate(), log.getLogDate());
        List<RecoveryCurveProfile> curves = recoveryCurveService.getCurveForSurgery(patient.getSurgeryType());
        List<DeviationRule> rules = deviationRuleService.getActiveRules();

        for (DeviationRule rule : rules) {
            if ("PAIN".equals(rule.getParameter()) && log.getPainLevel() != null) {
                RecoveryCurveProfile expectedCurve = curves.stream()
                        .filter(c -> c.getDayNumber() == daysSinceSurgery)
                        .findFirst().orElse(null);

                if (expectedCurve != null && log.getPainLevel() > expectedCurve.getExpectedPainLevel() + rule.getThreshold()) {
                    ClinicalAlertRecord alert = ClinicalAlertRecord.builder()
                            .patientId(log.getPatientId())
                            .logId(log.getId())
                            .alertType("PAIN_SPIKE")
                            .severity(rule.getSeverity())
                            .message("Pain level exceeded expected range")
                            .resolved(false)
                            .build();

                    clinicalAlertRecordRepository.save(alert);
                }
            }
        }
    }
}