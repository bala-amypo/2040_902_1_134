package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
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
    public String register(RegisterRequest request) {
        AppUser user = new AppUser();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        repository.save(user);
        return "User registered";
    }

    @Override
    public String login(AuthRequest request) {
        return "Login successful";
    }
}
