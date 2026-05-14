package com.gaurav.employeehrdashboardapp.service;

// ================= IMPORTS =================


// ================= USER SERVICE INTERFACE =================
// Defines business operations for User authentication

import com.gaurav.employeehrdashboardapp.entity.User;

public interface UserService {

    // =========================================================
    // USER REGISTRATION
    // Creates a new user in the system
    // =========================================================

    User register(User user);

    // =========================================================
    // USER LOGIN
    // Validates username and password for authentication
    // =========================================================

    User login(String username, String password);
}