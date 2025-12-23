package com.example.demo.controller;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.service.RecoveryCurveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recovery-curves")
public class RecoveryCurveController {

    private final RecoveryCurveService service;

    public RecoveryCurveController(RecoveryCurveService service) {
        this.service = service;
    }

    @PostMapping
    public RecoveryCurveProfile create(@RequestBody RecoveryCurveProfile curve) {
        return service.create(curve);
    }

    @GetMapping("/patient/{patientId}")
    public List<RecoveryCurveProfile> getByPatient(@PathVariable Long patientId) {
        return service.getByPatientId(patientId);
    }
}
