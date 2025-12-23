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

    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alert) {
        return repository.save(alert);
    }

    public List<ClinicalAlertRecord> getAlertsForPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}
