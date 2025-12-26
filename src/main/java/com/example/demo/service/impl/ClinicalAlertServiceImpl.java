package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalAlertServiceImpl
        implements ClinicalAlertService, ClinicalAlertRecordRepository {

    private final ClinicalAlertRecordRepository repository;

    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository repository) {
        this.repository = repository;
    }

    // =========================
    // Service methods
    // =========================
    @Override
    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    // =========================
    // Repository delegation
    // =========================
    @Override
    public <S extends ClinicalAlertRecord> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<ClinicalAlertRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<ClinicalAlertRecord> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
