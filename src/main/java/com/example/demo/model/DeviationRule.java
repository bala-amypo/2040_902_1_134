package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deviation_rules")
public class DeviationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String ruleCode;
    
    private String parameter;
    private Integer threshold;
    private String severity;
    
    private Boolean active = true;
    
    public DeviationRule() {}
    
    public DeviationRule(Long id, String ruleCode, String parameter, Integer threshold, String severity, Boolean active) {
        this.id = id;
        this.ruleCode = ruleCode;
        this.parameter = parameter;
        this.threshold = threshold;
        this.severity = severity;
        this.active = active != null ? active : true;
    }
    
    public static DeviationRuleBuilder builder() {
        return new DeviationRuleBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getRuleCode() { return ruleCode; }
    public void setRuleCode(String ruleCode) { this.ruleCode = ruleCode; }
    
    public String getParameter() { return parameter; }
    public void setParameter(String parameter) { this.parameter = parameter; }
    
    public Integer getThreshold() { return threshold; }
    public void setThreshold(Integer threshold) { this.threshold = threshold; }
    
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public static class DeviationRuleBuilder {
        private Long id;
        private String ruleCode;
        private String parameter;
        private Integer threshold;
        private String severity;
        private Boolean active = true;
        
        public DeviationRuleBuilder id(Long id) { this.id = id; return this; }
        public DeviationRuleBuilder ruleCode(String ruleCode) { this.ruleCode = ruleCode; return this; }
        public DeviationRuleBuilder parameter(String parameter) { this.parameter = parameter; return this; }
        public DeviationRuleBuilder threshold(Integer threshold) { this.threshold = threshold; return this; }
        public DeviationRuleBuilder severity(String severity) { this.severity = severity; return this; }
        public DeviationRuleBuilder active(Boolean active) { this.active = active; return this; }
        
        public DeviationRule build() {
            return new DeviationRule(id, ruleCode, parameter, threshold, severity, active);
        }
    }
}