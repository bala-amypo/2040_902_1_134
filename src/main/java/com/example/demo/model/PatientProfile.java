package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_profiles")
public class PatientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String patientId;
    
    private String fullName;
    private Integer age;
    private String email;
    private String surgeryType;
    
    private Boolean active = true;
    
    private LocalDateTime createdAt;
    
    public PatientProfile() {}
    
    public PatientProfile(Long id, String patientId, String fullName, Integer age, String email, String surgeryType, Boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.surgeryType = surgeryType;
        this.active = active != null ? active : true;
        this.createdAt = createdAt;
    }
    
    public static PatientProfileBuilder builder() {
        return new PatientProfileBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getSurgeryType() { return surgeryType; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public static class PatientProfileBuilder {
        private Long id;
        private String patientId;
        private String fullName;
        private Integer age;
        private String email;
        private String surgeryType;
        private Boolean active = true;
        private LocalDateTime createdAt;
        
        public PatientProfileBuilder id(Long id) { this.id = id; return this; }
        public PatientProfileBuilder patientId(String patientId) { this.patientId = patientId; return this; }
        public PatientProfileBuilder fullName(String fullName) { this.fullName = fullName; return this; }
        public PatientProfileBuilder age(Integer age) { this.age = age; return this; }
        public PatientProfileBuilder email(String email) { this.email = email; return this; }
        public PatientProfileBuilder surgeryType(String surgeryType) { this.surgeryType = surgeryType; return this; }
        public PatientProfileBuilder active(Boolean active) { this.active = active; return this; }
        public PatientProfileBuilder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        
        public PatientProfile build() {
            return new PatientProfile(id, patientId, fullName, age, email, surgeryType, active, createdAt);
        }
    }
}