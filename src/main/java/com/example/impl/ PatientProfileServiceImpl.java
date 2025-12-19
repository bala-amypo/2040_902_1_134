package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;
import java.time.LocalDateTime;
import java.util.List;

public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repository;

    public PatientProfileServiceImpl(PatientProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientProfile createPatient(PatientProfile patient) {
        if (repository.findByEmail(patient.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        patient.setCreatedAt(LocalDateTime.now());
        return repository.save(patient);
    }

    @Override
    public PatientProfile getPatientById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
    }

    @Override
    public List<PatientProfile> getAllPatients() {
        return repository.findAll();
    }
}
