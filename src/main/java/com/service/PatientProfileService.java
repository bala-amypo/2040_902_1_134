package com.example.demo.service;

import com.example.demo.model.PatientProfile;

import java.util.List;

public interface PatientProfileService {
    PatientProfile createProfile(PatientProfile patient);
    PatientProfile getProfileById(Long id);
    List<PatientProfile> getAllProfiles();
}
