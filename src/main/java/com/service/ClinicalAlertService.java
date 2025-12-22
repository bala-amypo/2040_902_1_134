package com.example.demo.service;

import com.example.demo.model.ClinicalAlert;
import java.util.List;

public interface ClinicalAlertService {

    ClinicalAlert createAlert(ClinicalAlert alert);

    List<ClinicalAlert> getAlertsByPatient(Long patientId);

    ClinicalAlert resolveAlert(Long alertId);

    List<ClinicalAlert> getAllAlerts();
}
