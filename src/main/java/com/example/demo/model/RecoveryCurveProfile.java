package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "recovery_curve_profile")
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String recoveryStage;
    private String date;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    public String getRecoveryStage() { return recoveryStage; }
    public void setRecoveryStage(String recoveryStage) { this.recoveryStage = recoveryStage; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
