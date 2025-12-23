package com.example.demo.service.impl;

import com.example.demo.model.RecoveryCurveProfile;
import com.example.demo.repository.RecoveryCurveRepository;
import com.example.demo.service.RecoveryCurveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryCurveServiceImpl implements RecoveryCurveService {

    private final RecoveryCurveRepository repository;

    public RecoveryCurveServiceImpl(RecoveryCurveRepository repository) {
        this.repository = repository;
    }

    public RecoveryCurveProfile create(RecoveryCurveProfile curve) {
        return repository.save(curve);
    }

    public List<RecoveryCurveProfile> getByPatientId(Long patientId) {
        return repository.findByPatientId(patientId);
    }
}
