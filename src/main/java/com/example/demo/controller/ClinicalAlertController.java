package com.example.demo.controller;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.service.ClinicalAlertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Clinical Alerts", description = "Clinical alert management operations")
@SecurityRequirement(name = "bearerAuth")
public class ClinicalAlertController {
    
    private final ClinicalAlertService clinicalAlertService;
    
    public ClinicalAlertController(ClinicalAlertService clinicalAlertService) {
        this.clinicalAlertService = clinicalAlertService;
    }
    
    @PostMapping
    @Operation(summary = "Trigger alert")
    public ResponseEntity<ClinicalAlertRecord> createAlert(@RequestBody ClinicalAlertRecord alert) {
        return ResponseEntity.ok(clinicalAlertService.createAlert(alert));
    }
    
    @PutMapping("/{id}/resolve")
    @Operation(summary = "Resolve alert")
    public ResponseEntity<ClinicalAlertRecord> resolveAlert(@PathVariable Long id) {
        return ResponseEntity.ok(clinicalAlertService.resolveAlert(id));
    }
    
    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get alerts for patient")
    public ResponseEntity<List<ClinicalAlertRecord>> getAlertsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(clinicalAlertService.getAlertsByPatient(patientId));
    }
    
    @GetMapping
    @Operation(summary = "List all alerts")
    public ResponseEntity<List<ClinicalAlertRecord>> getAllAlerts() {
        return ResponseEntity.ok(clinicalAlertService.getAllAlerts());
    }
}