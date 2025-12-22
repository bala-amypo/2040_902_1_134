package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlert;
import com.example.demo.repository.ClinicalAlertRepository;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRepository repository;

    public ClinicalAlertServiceImpl(ClinicalAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalAlert createAlert(ClinicalAlert alert) {
        alert.setResolved(false);
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlert> getAlertsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    @Override
    public ClinicalAlert resolveAlert(Long alertId) {
        ClinicalAlert alert = repository.findById(alertId).orElse(null);
        if (alert != null) {
            alert.setResolved(true);
            repository.save(alert);
        }
        return alert;
    }

    @Override
    public List<ClinicalAlert> getAllAlerts() {
        return repository.findAll();
    }
}
