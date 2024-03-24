package com.dev.springsecurityjwt.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.dev.springsecurityjwt.security.services.JwtService;

@Service
public class AuthService {
    private final JwtService jwtService;

    public AuthService(JwtService jwtService){
        this.jwtService = jwtService;
    }

    public String authenticate(Authentication authentication){
        return jwtService.generateToken(authentication);
    }
}
