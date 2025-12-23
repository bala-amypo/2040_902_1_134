package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symptom;

    private Double thresholdDeviation;

    // getters & setters
    public Long getId() {
        return id;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public Double getThresholdDeviation() {
        return thresholdDeviation;
    }

    public void setThresholdDeviation(Double thresholdDeviation) {
        this.thresholdDeviation = thresholdDeviation;
    }
}
