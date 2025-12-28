package com.example.demo.config;

import com.example.demo.model.AppUser;
import com.example.demo.model.UserRole;
import com.example.demo.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create sample users for testing
        if (appUserRepository.findByEmail("admin@demo.com").isEmpty()) {
            AppUser admin = AppUser.builder()
                    .email("admin@demo.com")
                    .password(passwordEncoder.encode("admin123"))
                    .fullName("Admin User")
                    .role(UserRole.ADMIN)
                    .build();
            appUserRepository.save(admin);
        }

        if (appUserRepository.findByEmail("clinician@demo.com").isEmpty()) {
            AppUser clinician = AppUser.builder()
                    .email("clinician@demo.com")
                    .password(passwordEncoder.encode("clinician123"))
                    .fullName("Dr. Smith")
                    .role(UserRole.CLINICIAN)
                    .build();
            appUserRepository.save(clinician);
        }

        if (appUserRepository.findByEmail("assistant@demo.com").isEmpty()) {
            AppUser assistant = AppUser.builder()
                    .email("assistant@demo.com")
                    .password(passwordEncoder.encode("assistant123"))
                    .fullName("Health Assistant")
                    .role(UserRole.HEALTH_ASSISTANT)
                    .build();
            appUserRepository.save(assistant);
        }
    }
}