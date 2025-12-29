package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clinical_alert_records")
public class ClinicalAlertRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long patientId;
    private Long logId;
    private String alertType;
    private String severity;
    private String message;
    
    private Boolean resolved = false;
    
    public ClinicalAlertRecord() {}
    
    public ClinicalAlertRecord(Long id, Long patientId, Long logId, String alertType, String severity, String message, Boolean resolved) {
        this.id = id;
        this.patientId = patientId;
        this.logId = logId;
        this.alertType = alertType;
        this.severity = severity;
        this.message = message;
        this.resolved = resolved != null ? resolved : false;
    }
    
    public static ClinicalAlertRecordBuilder builder() {
        return new ClinicalAlertRecordBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    
    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }
    
    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    
    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    
    public static class ClinicalAlertRecordBuilder {
        private Long id;
        private Long patientId;
        private Long logId;
        private String alertType;
        private String severity;
        private String message;
        private Boolean resolved = false;
        
        public ClinicalAlertRecordBuilder id(Long id) { this.id = id; return this; }
        public ClinicalAlertRecordBuilder patientId(Long patientId) { this.patientId = patientId; return this; }
        public ClinicalAlertRecordBuilder logId(Long logId) { this.logId = logId; return this; }
        public ClinicalAlertRecordBuilder alertType(String alertType) { this.alertType = alertType; return this; }
        public ClinicalAlertRecordBuilder severity(String severity) { this.severity = severity; return this; }
        public ClinicalAlertRecordBuilder message(String message) { this.message = message; return this; }
        public ClinicalAlertRecordBuilder resolved(Boolean resolved) { this.resolved = resolved; return this; }
        
        public ClinicalAlertRecord build() {
            return new ClinicalAlertRecord(id, patientId, logId, alertType, severity, message, resolved);
        }
    }
}