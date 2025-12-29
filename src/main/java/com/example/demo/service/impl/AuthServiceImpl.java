package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.AppUser;
import com.example.demo.model.UserRole;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // ✅ PRIMARY CONSTRUCTOR (USED BY SPRING)
    public AuthServiceImpl(AppUserRepository appUserRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // ✅ SECONDARY CONSTRUCTOR (USED BY TESTS — DO NOT REMOVE)
    public AuthServiceImpl(AppUserRepository appUserRepository,
                           PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,
                           JwtTokenProvider jwtTokenProvider) {
        this(appUserRepository, passwordEncoder, jwtTokenProvider);
        // authenticationManager intentionally ignored
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (appUserRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        UserRole role = request.getRole() != null
                ? request.getRole()
                : UserRole.CLINICIAN;

        AppUser user = AppUser.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .role(role)
                .build();

        AppUser savedUser = appUserRepository.save(user);

        String token = jwtTokenProvider.generateToken(savedUser);

        return new AuthResponse(
                token,
                savedUser.getEmail(),
                savedUser.getRole(),
                savedUser.getId()
        );
    }

    @Override
    public AuthResponse login(AuthRequest request) {

        AppUser user = appUserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        // ✅ Manual password validation (JWT-based auth)
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtTokenProvider.generateToken(user);

        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole(),
                user.getId()
        );
    }
}
