package com.gaurav.employeehrdashboardapp.service;

// ================= IMPORTS =================

import com.gaurav.employeehrdashboardapp.entity.User;
import com.gaurav.employeehrdashboardapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ================= SERVICE IMPLEMENTATION =================
// Handles business logic for user registration and login

@Service
public class UserServiceImpl implements UserService {

    // ================= REPOSITORY INJECTION =================
    // Used for database operations on User entity

    @Autowired
    private UserRepository repo;

    // =========================================================
    // USER REGISTRATION
    // Checks if username already exists before saving
    // =========================================================

    public User register(User user) {

        // Prevent duplicate usernames
        if (repo.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username exists");
        }

        // Save new user to database
        return repo.save(user);
    }

    // =========================================================
    // USER LOGIN
    // Validates username and password
    // =========================================================

    public User login(String username, String password) {

        // Fetch user by username or throw exception if not found
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate password
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }

        // Return authenticated user
        return user;
    }
}