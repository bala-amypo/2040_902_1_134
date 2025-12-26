package com.example.demo.service.impl;

import com.example.demo.model.ClinicalAlertRecord;
import com.example.demo.repository.ClinicalAlertRecordRepository;
import com.example.demo.service.ClinicalAlertService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalAlertServiceImpl
        extends SimpleJpaRepository<ClinicalAlertRecord, Long>
        implements ClinicalAlertService {

    private final ClinicalAlertRecordRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    // ✅ CONSTRUCTOR USED BY TESTS
    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository repository) {
        super(ClinicalAlertRecord.class, null);
        this.repository = repository;
    }

    // ✅ CONSTRUCTOR USED BY SPRING
    public ClinicalAlertServiceImpl(ClinicalAlertRecordRepository repository,
                                    EntityManager entityManager) {
        super(ClinicalAlertRecord.class, entityManager);
        this.repository = repository;
        this.entityManager = entityManager;
    }

    @Override
    public ClinicalAlertRecord createAlert(ClinicalAlertRecord alert) {
        return repository.save(alert);
    }

    @Override
    public Optional<ClinicalAlertRecord> getAlertById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ClinicalAlertRecord resolveAlert(long id) {
        Optional<ClinicalAlertRecord> opt = repository.findById(id);
        if (opt.isPresent()) {
            ClinicalAlertRecord alert = opt.get();
            alert.setResolved(true);
            return repository.save(alert);
        }
        return null;
    }

    @Override
    public List<ClinicalAlertRecord> getAlertsByPatient(long patientId) {
        return repository.findByPatientId(patientId);
    }

    @Override
    public List<ClinicalAlertRecord> findByPatientId(long patientId) {
        return repository.findByPatientId(patientId);
    }

    @Override
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repository.findAll();
    }
}
