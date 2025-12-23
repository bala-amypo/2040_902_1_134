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

    @PostMapping
    public ClinicalAlertRecord create(@RequestBody ClinicalAlertRecord alert) {
        return service.createAlert(alert);
    }

    @GetMapping("/patient/{id}")
    public List<ClinicalAlertRecord> byPatient(@PathVariable Long id) {
        return service.getAlertsForPatient(id);
    }
}
