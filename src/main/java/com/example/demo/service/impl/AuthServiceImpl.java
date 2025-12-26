package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
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
    public String login(AuthRequest request) {
        AppUser u = repository.findByUsername(request.getUsername());
        if (u != null && u.getPassword().equals(request.getPassword())) {
            // Return a dummy JWT token for now, actual JWT logic will go in JwtTokenProvider
            return "JWT-TOKEN-FOR-" + u.getUsername();
        }
        throw new RuntimeException("Invalid credentials");
    }
}
