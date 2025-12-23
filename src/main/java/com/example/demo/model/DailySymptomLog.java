package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private String symptoms;
    private int painLevel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public int getPainLevel() { return painLevel; }
    public void setPainLevel(int painLevel) { this.painLevel = painLevel; }
}
