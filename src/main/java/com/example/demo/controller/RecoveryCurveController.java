package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recovery-curves")
@Tag(name = "Recovery Curves", description = "Recovery curve management operations")
@SecurityRequirement(name = "bearerAuth")
public class RecoveryCurveController {
    
    private final RecoveryCurveService recoveryCurveService;
    
    public RecoveryCurveController(RecoveryCurveService recoveryCurveService) {
        this.recoveryCurveService = recoveryCurveService;
    }
    
    @PostMapping
    @Operation(summary = "Create curve entry")
    public ResponseEntity<RecoveryCurveProfile> createCurveEntry(@RequestBody RecoveryCurveProfile curve) {
        return ResponseEntity.ok(recoveryCurveService.createCurveEntry(curve));
    }
    
    @GetMapping("/surgery/{surgeryType}")
    @Operation(summary = "Get curve for surgery type")
    public ResponseEntity<List<RecoveryCurveProfile>> getCurveForSurgery(@PathVariable String surgeryType) {
        return ResponseEntity.ok(recoveryCurveService.getCurveForSurgery(surgeryType));
    }
    
    @GetMapping
    @Operation(summary = "List all curve entries")
    public ResponseEntity<List<RecoveryCurveProfile>> getAllCurves() {
        return ResponseEntity.ok(recoveryCurveService.getAllCurves());
    }
}