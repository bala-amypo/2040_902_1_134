package com.example.demo.service;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;

import java.util.List;

public interface ClinicalAlertService extends ClinicalAlertRecordRepository {

    ClinicalAlertRecord createAlert(ClinicalAlertRecord alert);

    ClinicalAlertRecord getAlertById(Long id);

    List<ClinicalAlertRecord> getAllAlerts();
}
