package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class ClinicalAlertController {

    private final ClinicalAlertService service;

    public ClinicalAlertController(ClinicalAlertService service) {
        this.service = service;
    }

    @GetMapping("/patient/{patientId}")
    public List<ClinicalAlertRecord> getAlerts(@PathVariable Long patientId) {
        return service.getAlertsForPatient(patientId);
    }
}
