package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalAlertServiceImpl
        extends SimpleJpaRepository<ClinicalAlertRecord, Long>
        implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository repository;

    public ClinicalAlertServiceImpl(
            ClinicalAlertRecordRepository repository,
            EntityManager entityManager) {

        super(ClinicalAlertRecord.class, entityManager);
        this.repository = repository;
    }

    @Override
    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public ClinicalAlertRecord getAlertById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}
