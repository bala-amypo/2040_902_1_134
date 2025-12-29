package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "daily_symptom_logs")
public class DailySymptomLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long patientId;
    private LocalDate logDate;
    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;
    private String additionalNotes;
    
    public DailySymptomLog() {}
    
    public DailySymptomLog(Long id, Long patientId, LocalDate logDate, Integer painLevel, Integer mobilityLevel, Integer fatigueLevel, String additionalNotes) {
        this.id = id;
        this.patientId = patientId;
        this.logDate = logDate;
        this.painLevel = painLevel;
        this.mobilityLevel = mobilityLevel;
        this.fatigueLevel = fatigueLevel;
        this.additionalNotes = additionalNotes;
    }
    
    public static DailySymptomLogBuilder builder() {
        return new DailySymptomLogBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
    
    public LocalDate getLogDate() { return logDate; }
    public void setLogDate(LocalDate logDate) { this.logDate = logDate; }
    
    public Integer getPainLevel() { return painLevel; }
    public void setPainLevel(Integer painLevel) { this.painLevel = painLevel; }
    
    public Integer getMobilityLevel() { return mobilityLevel; }
    public void setMobilityLevel(Integer mobilityLevel) { this.mobilityLevel = mobilityLevel; }
    
    public Integer getFatigueLevel() { return fatigueLevel; }
    public void setFatigueLevel(Integer fatigueLevel) { this.fatigueLevel = fatigueLevel; }
    
    public String getAdditionalNotes() { return additionalNotes; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }
    
    public static class DailySymptomLogBuilder {
        private Long id;
        private Long patientId;
        private LocalDate logDate;
        private Integer painLevel;
        private Integer mobilityLevel;
        private Integer fatigueLevel;
        private String additionalNotes;
        
        public DailySymptomLogBuilder id(Long id) { this.id = id; return this; }
        public DailySymptomLogBuilder patientId(Long patientId) { this.patientId = patientId; return this; }
        public DailySymptomLogBuilder logDate(LocalDate logDate) { this.logDate = logDate; return this; }
        public DailySymptomLogBuilder painLevel(Integer painLevel) { this.painLevel = painLevel; return this; }
        public DailySymptomLogBuilder mobilityLevel(Integer mobilityLevel) { this.mobilityLevel = mobilityLevel; return this; }
        public DailySymptomLogBuilder fatigueLevel(Integer fatigueLevel) { this.fatigueLevel = fatigueLevel; return this; }
        public DailySymptomLogBuilder additionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; return this; }
        
        public DailySymptomLog build() {
            return new DailySymptomLog(id, patientId, logDate, painLevel, mobilityLevel, fatigueLevel, additionalNotes);
        }
    }
}