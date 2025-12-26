package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clinical_alert_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicalAlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private Long patientId;

    private String alertMessage;

    private Boolean resolved;

    private String ruleCode;

    // Add any additional fields referenced in your test cases
    // For example, timestamps if needed
    // private LocalDateTime createdAt;

    // You can also add convenience methods if your test cases reference them
}
