package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ClinicalAlertRecord;

public interface ClinicalAlertService {
    List<ClinicalAlertRecord> getAllAlerts();
    ClinicalAlertRecord resolveAlert(Long alertId);
}
