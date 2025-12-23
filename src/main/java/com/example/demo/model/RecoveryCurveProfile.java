package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private int expectedPainLevel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public int getExpectedPainLevel() { return expectedPainLevel; }
    public void setExpectedPainLevel(int expectedPainLevel) {
        this.expectedPainLevel = expectedPainLevel;
    }
}
