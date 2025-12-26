package com.example.demo.model;

public class ClinicalAlertRecord {

    private Long id;
    private boolean resolved;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }
}
