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
        alert.setResolved(false);
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    @Override
    public ClinicalAlertRecord resolveAlert(Long alertId) {
        ClinicalAlertRecord alert =
                repository.findById(alertId).orElse(null);

        if (alert != null) {
            alert.setResolved(true);
            repository.save(alert);
        }
        return alert;
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}
