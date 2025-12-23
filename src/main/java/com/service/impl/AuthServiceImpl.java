package com.example.demo.service.impl;

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

    public AppUser register(AppUser user) {
        return repository.save(user);
    }

    public boolean login(String username, String password) {
        return repository.findByUsername(username)
                .map(u -> u.getPassword().equals(password))
                .orElse(false);
    }
}
