package com.example.demo.controller;

import com.example.demo.model.DeviationRule;
import com.example.demo.service.DeviationRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deviation-rules")
@Tag(name = "Deviation Rules", description = "Deviation rule management operations")
@SecurityRequirement(name = "bearerAuth")
public class DeviationRuleController {
    
    private final DeviationRuleService deviationRuleService;
    
    public DeviationRuleController(DeviationRuleService deviationRuleService) {
        this.deviationRuleService = deviationRuleService;
    }
    
    @PostMapping
    @Operation(summary = "Create deviation rule")
    public ResponseEntity<DeviationRule> createRule(@RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.createRule(rule));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Update rule")
    public ResponseEntity<DeviationRule> updateRule(@PathVariable Long id, @RequestBody DeviationRule rule) {
        return ResponseEntity.ok(deviationRuleService.updateRule(id, rule));
    }
    
    @GetMapping("/active")
    @Operation(summary = "List active rules")
    public ResponseEntity<List<DeviationRule>> getActiveRules() {
        return ResponseEntity.ok(deviationRuleService.getActiveRules());
    }
}