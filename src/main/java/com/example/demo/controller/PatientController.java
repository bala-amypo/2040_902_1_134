package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient Management", description = "Patient profile operations")
public class PatientController {
    
    private final PatientProfileService patientProfileService;
    
    public PatientController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }
    
    @GetMapping
    @Operation(summary = "Get all patients")
    public ResponseEntity<List<PatientProfile>> getAllPatients() {
        return ResponseEntity.ok(patientProfileService.getAllPatients());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get patient by ID")
    public ResponseEntity<PatientProfile> getPatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientProfileService.getPatientById(id));
    }
    
    @PostMapping
    @Operation(summary = "Create new patient")
    public ResponseEntity<PatientProfile> createPatient(@RequestBody PatientProfile patient) {
        return ResponseEntity.ok(patientProfileService.createPatient(patient));
    }
}
