package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DeviationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int thresholdPain;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getThresholdPain() { return thresholdPain; }
    public void setThresholdPain(int thresholdPain) {
        this.thresholdPain = thresholdPain;
    }
}
