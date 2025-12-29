package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient Management", description = "Patient profile operations")
@SecurityRequirement(name = "bearerAuth")
public class PatientProfileController {
    
    private final PatientProfileService patientProfileService;
    
    public PatientProfileController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }
    
    @PostMapping
    @Operation(summary = "Create patient")
    public ResponseEntity<PatientProfile> createPatient(@RequestBody PatientProfile patient) {
        return ResponseEntity.ok(patientProfileService.createPatient(patient));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get patient by ID")
    public ResponseEntity<PatientProfile> getPatient(@PathVariable Long id) {
        return ResponseEntity.ok(patientProfileService.getPatientById(id));
    }
    
    @GetMapping
    @Operation(summary = "List all patients")
    public ResponseEntity<List<PatientProfile>> getAllPatients() {
        return ResponseEntity.ok(patientProfileService.getAllPatients());
    }
    
    @PutMapping("/{id}/status")
    @Operation(summary = "Activate/deactivate patient")
    public ResponseEntity<PatientProfile> updatePatientStatus(@PathVariable Long id, @RequestParam Boolean active) {
        return ResponseEntity.ok(patientProfileService.updatePatientStatus(id, active));
    }
    
    @GetMapping("/lookup/{patientId}")
    @Operation(summary = "Lookup by patientId")
    public ResponseEntity<Optional<PatientProfile>> findByPatientId(@PathVariable String patientId) {
        return ResponseEntity.ok(patientProfileService.findByPatientId(patientId));
    }
}