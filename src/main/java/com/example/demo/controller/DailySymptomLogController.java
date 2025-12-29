package com.example.demo.controller;

import com.example.demo.model.DailySymptomLog;
import com.example.demo.service.DailySymptomLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptom-logs")
@Tag(name = "Daily Symptom Logs", description = "Daily symptom logging operations")
@SecurityRequirement(name = "bearerAuth")
public class DailySymptomLogController {
    
    private final DailySymptomLogService dailySymptomLogService;
    
    public DailySymptomLogController(DailySymptomLogService dailySymptomLogService) {
        this.dailySymptomLogService = dailySymptomLogService;
    }
    
    @PostMapping
    @Operation(summary = "Record daily symptom log")
    public ResponseEntity<DailySymptomLog> recordSymptomLog(@RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(dailySymptomLogService.recordSymptomLog(log));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update symptom log")
    public ResponseEntity<DailySymptomLog> updateSymptomLog(@PathVariable Long id, @RequestBody DailySymptomLog log) {
        return ResponseEntity.ok(dailySymptomLogService.updateSymptomLog(id, log));
    }
    
    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Get logs by patient")
    public ResponseEntity<List<DailySymptomLog>> getLogsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(dailySymptomLogService.getLogsByPatient(patientId));
    }
}