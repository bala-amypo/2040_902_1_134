package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.model.AppUser;

public interface AuthService {
    String login(AuthRequest request);
}
