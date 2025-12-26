package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;

import java.util.List;
import java.util.Optional;

public interface ClinicalAlertService
        extends ClinicalAlertRecordRepository {

    ClinicalAlertRecord createAlert(ClinicalAlertRecord alert);

    Optional<ClinicalAlertRecord> getAlertById(Long id);

    ClinicalAlertRecord resolveAlert(long id);

    List<ClinicalAlertRecord> getAlertsByPatient(long patientId);

    List<ClinicalAlertRecord> getAllAlerts();
}
