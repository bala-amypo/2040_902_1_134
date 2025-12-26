package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "recovery_curves")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecoveryCurveProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surgeryType;

    private int dayNumber;

    private int expectedPainLevel;
}
