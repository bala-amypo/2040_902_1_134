package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recovery_curve_profiles")
public class RecoveryCurveProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String surgeryType;
    private Integer dayNumber;
    private Integer expectedPainLevel;
    private Integer expectedMobilityLevel;
    private Integer expectedFatigueLevel;
    
    public RecoveryCurveProfile() {}
    
    public RecoveryCurveProfile(Long id, String surgeryType, Integer dayNumber, Integer expectedPainLevel, Integer expectedMobilityLevel, Integer expectedFatigueLevel) {
        this.id = id;
        this.surgeryType = surgeryType;
        this.dayNumber = dayNumber;
        this.expectedPainLevel = expectedPainLevel;
        this.expectedMobilityLevel = expectedMobilityLevel;
        this.expectedFatigueLevel = expectedFatigueLevel;
    }
    
    public static RecoveryCurveProfileBuilder builder() {
        return new RecoveryCurveProfileBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getSurgeryType() { return surgeryType; }
    public void setSurgeryType(String surgeryType) { this.surgeryType = surgeryType; }
    
    public Integer getDayNumber() { return dayNumber; }
    public void setDayNumber(Integer dayNumber) { this.dayNumber = dayNumber; }
    
    public Integer getExpectedPainLevel() { return expectedPainLevel; }
    public void setExpectedPainLevel(Integer expectedPainLevel) { this.expectedPainLevel = expectedPainLevel; }
    
    public Integer getExpectedMobilityLevel() { return expectedMobilityLevel; }
    public void setExpectedMobilityLevel(Integer expectedMobilityLevel) { this.expectedMobilityLevel = expectedMobilityLevel; }
    
    public Integer getExpectedFatigueLevel() { return expectedFatigueLevel; }
    public void setExpectedFatigueLevel(Integer expectedFatigueLevel) { this.expectedFatigueLevel = expectedFatigueLevel; }
    
    public static class RecoveryCurveProfileBuilder {
        private Long id;
        private String surgeryType;
        private Integer dayNumber;
        private Integer expectedPainLevel;
        private Integer expectedMobilityLevel;
        private Integer expectedFatigueLevel;
        
        public RecoveryCurveProfileBuilder id(Long id) { this.id = id; return this; }
        public RecoveryCurveProfileBuilder surgeryType(String surgeryType) { this.surgeryType = surgeryType; return this; }
        public RecoveryCurveProfileBuilder dayNumber(Integer dayNumber) { this.dayNumber = dayNumber; return this; }
        public RecoveryCurveProfileBuilder expectedPainLevel(Integer expectedPainLevel) { this.expectedPainLevel = expectedPainLevel; return this; }
        public RecoveryCurveProfileBuilder expectedMobilityLevel(Integer expectedMobilityLevel) { this.expectedMobilityLevel = expectedMobilityLevel; return this; }
        public RecoveryCurveProfileBuilder expectedFatigueLevel(Integer expectedFatigueLevel) { this.expectedFatigueLevel = expectedFatigueLevel; return this; }
        
        public RecoveryCurveProfile build() {
            return new RecoveryCurveProfile(id, surgeryType, dayNumber, expectedPainLevel, expectedMobilityLevel, expectedFatigueLevel);
        }
    }
}