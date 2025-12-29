package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    private String fullName;
    
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    public AppUser() {}
    
    public AppUser(Long id, String email, String password, String fullName, UserRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
    
    public static AppUserBuilder builder() {
        return new AppUserBuilder();
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }
    
    public static class AppUserBuilder {
        private Long id;
        private String email;
        private String password;
        private String fullName;
        private UserRole role;
        
        public AppUserBuilder id(Long id) { this.id = id; return this; }
        public AppUserBuilder email(String email) { this.email = email; return this; }
        public AppUserBuilder password(String password) { this.password = password; return this; }
        public AppUserBuilder fullName(String fullName) { this.fullName = fullName; return this; }
        public AppUserBuilder role(UserRole role) { this.role = role; return this; }
        
        public AppUser build() {
            return new AppUser(id, email, password, fullName, role);
        }
    }
}