package com.dev.springsecurityjwt.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.springsecurityjwt.services.AuthService;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("authenticate")
    public String authenticate(Authentication authentication){
        return authService.authenticate(authentication);
    }
}
