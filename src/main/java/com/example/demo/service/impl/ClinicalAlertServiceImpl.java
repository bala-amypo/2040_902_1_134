package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalAlertServiceImpl implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository repository;

    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alertRecord) {
        // When creating, resolved should default to false
        alertRecord.setResolved(false);
        return repository.save(alertRecord);
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    @Override
    public ClinicalAlertRecord resolveAlert(Long logId) {
        Optional<ClinicalAlertRecord> optional = repository.findById(logId);
        if (optional.isPresent()) {
            ClinicalAlertRecord alert = optional.get();
            alert.setResolved(true);
            return repository.save(alert);
        }
        return null; // or throw exception depending on your design
    }
}
