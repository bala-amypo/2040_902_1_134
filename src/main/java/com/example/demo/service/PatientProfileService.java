package com.example.demo.service;

import com.example.demo.model.PatientProfile;
import java.util.List;

public interface PatientProfileService {
    List<PatientProfile> getAllPatients();
    PatientProfile getPatientById(Long id); // add this
}
