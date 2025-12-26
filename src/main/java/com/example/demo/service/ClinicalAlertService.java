package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;

import java.util.List;

public interface ClinicalAlertService {

    // Create a new alert
    ClinicalAlertRecord createAlert(ClinicalAlertRecord alertRecord);

    // Get all alerts for a specific patient
    List<ClinicalAlertRecord> getAlertsByPatient(Long patientId);

    // Resolve an alert by ID
    ClinicalAlertRecord resolveAlert(Long logId);
}
