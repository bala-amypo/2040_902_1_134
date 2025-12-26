package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private Integer age;

    private String surgeryType;

    private String doctorName;
}
