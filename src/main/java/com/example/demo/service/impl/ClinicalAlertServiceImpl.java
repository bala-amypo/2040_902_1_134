package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository repository;

    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    @Override
    public ClinicalAlertRecord getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteAlert(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsForPatient(Long patientId) {
        // Replace this with actual query if you have a patientId field
        return repository.findAll().stream()
                .filter(alert -> alert.getPatientId().equals(patientId))
                .toList();
    }
}
