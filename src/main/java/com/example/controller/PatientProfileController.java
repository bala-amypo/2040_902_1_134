package com.example.demo.controller;

import com.example.demo.model.PatientProfile;
import com.example.demo.service.PatientProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientProfileController {

    private final PatientProfileService service;

    public PatientProfileController(PatientProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PatientProfile create(@RequestBody PatientProfile patient) {
        return service.createProfile(patient);
    }

    @GetMapping("/{id}")
    public PatientProfile getById(@PathVariable Long id) {
        return service.getProfileById(id);
    }

    @GetMapping
    public List<PatientProfile> getAll() {
        return service.getAllProfiles();
    }
}
