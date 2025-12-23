package com.example.demo.service.impl;

import com.example.demo.model.PatientProfile;
import com.example.demo.repository.PatientProfileRepository;
import com.example.demo.service.PatientProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientProfileServiceImpl implements PatientProfileService {

    private final PatientProfileRepository repository;

    public PatientProfileServiceImpl(PatientProfileRepository repository) {
        this.repository = repository;
    }

    public PatientProfile createProfile(PatientProfile patient) {
        return repository.save(patient);
    }

    public PatientProfile getProfileById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<PatientProfile> getAllProfiles() {
        return repository.findAll();
    }
}
