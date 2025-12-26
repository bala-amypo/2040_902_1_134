package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
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
    public AuthResponse login(AuthRequest request) {
        AppUser u = repository.findByUsername(request.getUsername());
        if (u != null && u.getPassword().equals(request.getPassword())) {
            return new AuthResponse("JWT-TOKEN-FOR-" + u.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Override
    public void register(RegisterRequest request) {
        AppUser u = new AppUser();
        u.setUsername(request.getUsername());
        u.setPassword(request.getPassword());
        u.setEmail(request.getEmail());
        repository.save(u);
    }
}
