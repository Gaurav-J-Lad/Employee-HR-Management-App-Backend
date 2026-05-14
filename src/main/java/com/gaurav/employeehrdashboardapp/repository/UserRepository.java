package com.gaurav.employeehrdashboardapp.repository;

// ================= IMPORTS =================

import com.gaurav.employeehrdashboardapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// ================= USER REPOSITORY =================
// Handles database operations for User entity
// Provides built-in CRUD methods via JpaRepository

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // =========================================================
    // FIND USER BY USERNAME
    // Used for login authentication
    // Returns Optional to safely handle null cases
    // =========================================================

    Optional<User> findByUsername(String username);
}
