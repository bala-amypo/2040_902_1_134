package com.example.demo.repository;

import com.example.demo.model.RecoveryCurveProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecoveryCurveProfileRepository
        extends JpaRepository<RecoveryCurveProfile, Long> {

    RecoveryCurveProfile findByPatientId(String patientId);
}
