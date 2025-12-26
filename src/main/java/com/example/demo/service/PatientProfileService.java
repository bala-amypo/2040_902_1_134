package com.example.demo.service;

import com.example.demo.model.PatientProfile;

public interface PatientProfileService {
    PatientProfile findByPatientId(String patientId);
}
