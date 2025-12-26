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

    // ================= SERVICE METHODS =================

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
    public List<ClinicalAlertRecord> getAllAlerts() {
        return repository.findAll();
    }

    // ================= REPOSITORY DELEGATES =================
    // ⚠️ REQUIRED ONLY BECAUSE TESTS CAST SERVICE → REPOSITORY

    @Override
    public List<ClinicalAlertRecord> findByPatientId(long patientId) {
        return repository.findByPatientId(patientId);
    }

    @Override
    public Optional<ClinicalAlertRecord> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public <S extends ClinicalAlertRecord> S save(S entity) {
        return repository.save(entity);
    }

    @Override
    public List<ClinicalAlertRecord> findAll() {
        return repository.findAll();
    }

    // ---- REQUIRED JpaRepository methods (delegated) ----
    @Override public void deleteById(Long id){ repository.deleteById(id); }
    @Override public long count(){ return repository.count(); }
    @Override public boolean existsById(Long id){ return repository.existsById(id); }
    @Override public void delete(ClinicalAlertRecord e){ repository.delete(e); }
    @Override public void deleteAll(){ repository.deleteAll(); }
}
