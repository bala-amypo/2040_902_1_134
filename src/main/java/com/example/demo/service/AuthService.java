package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository repository;

    public AuthServiceImpl(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole("USER");
        repository.save(user);

        return new AuthResponse("User registered", user.getUsername());
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        AppUser user = repository.findByUsername(request.getUsername());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return new AuthResponse("Login successful", user.getUsername());
        }
        return new AuthResponse("Invalid credentials", null);
    }
}
