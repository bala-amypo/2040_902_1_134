package com.example.demo.security;

import com.example.demo.model.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    // Secret key for signing JWT tokens
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Token validity: 1 day
    private final long validityInMilliseconds = 24 * 60 * 60 * 1000; // 24 hours

    // Generate JWT token using AppUser details
    public String generateToken(AppUser user) {
        // Ensure AppUser has getId(), getEmail(), getRole() methods
        return Jwts.builder()
                .setSubject(user.getEmail())       // Email as subject
                .claim("id", user.getId())         // User ID claim
                .claim("role", user.getRole())     // Role claim
                .setIssuedAt(new Date())           // Issue time
                .setExpiration(new Date(System.currentTimeMillis() + validityInMilliseconds)) // Expiration
                .signWith(key)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Extract email from token
    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
