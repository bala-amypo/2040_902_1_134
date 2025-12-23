package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;

import java.util.List;

public interface RecoveryCurveService {
    RecoveryCurveProfile create(RecoveryCurveProfile curve);
    List<RecoveryCurveProfile> getByPatientId(Long patientId);
}
