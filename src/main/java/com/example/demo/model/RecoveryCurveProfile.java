package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metricName;

    private Double expectedMinValue;

    private Double expectedMaxValue;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientProfile patient;
}
