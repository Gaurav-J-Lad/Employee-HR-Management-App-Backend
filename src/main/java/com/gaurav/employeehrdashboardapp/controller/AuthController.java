package com.gaurav.employeehrdashboardapp.controller;

// ================= IMPORTS =================

import com.gaurav.employeehrdashboardapp.entity.User;
import com.gaurav.employeehrdashboardapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// ================= AUTH CONTROLLER =================
// Handles authentication-related APIs (register & login)

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    // ================= SERVICE INJECTION =================
    // Business logic handled in UserService

    @Autowired
    private UserService service;

    // =========================================================
    // USER REGISTRATION API
    // URL: POST /api/auth/register
    // =========================================================

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        // Call service to register user
        return service.register(user);
    }

    // =========================================================
    // USER LOGIN API
    // URL: POST /api/auth/login
    // =========================================================

    @PostMapping("/login")
    public User login(@RequestBody User req) {

        // Validate username and password via service
        return service.login(req.getUsername(), req.getPassword());
    }
}