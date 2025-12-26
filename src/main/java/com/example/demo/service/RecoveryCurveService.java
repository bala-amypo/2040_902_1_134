package com.example.demo.service;

import com.example.demo.model.RecoveryCurveProfile;

public interface RecoveryCurveService {
    RecoveryCurveProfile getCurveForSurgery(String patientId);
}
