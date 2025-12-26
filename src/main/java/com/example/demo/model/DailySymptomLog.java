package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_symptom_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private LocalDate logDate;

    private int painLevel;

    private boolean fever;

    private boolean nausea;
}
