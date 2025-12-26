package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;

import java.util.List;

public interface RecoveryCurveService {

    RecoveryCurveProfile create(RecoveryCurveProfile profile);

    List<RecoveryCurveProfile> getByPatientId(Long patientId);

    List<RecoveryCurveProfile> getAllCurves();
}
