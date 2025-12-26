package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;

import java.util.List;

public interface ClinicalAlertService {

    ClinicalAlertRecord createAlert(ClinicalAlertRecord alert);

    List<ClinicalAlertRecord> getAllAlerts();

    ClinicalAlertRecord getAlertById(Long id);

    void deleteAlert(Long id);

    // THIS MUST BE HERE, because your service impl references it
    List<ClinicalAlertRecord> getAlertsForPatient(Long patientId);
}
