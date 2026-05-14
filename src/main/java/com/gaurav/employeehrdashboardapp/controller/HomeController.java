package com.gaurav.employeehrdashboardapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {

    // ================= HOME PAGE (TEXT RESPONSE) =================
    // URL: GET /

    @GetMapping(value = "/", produces = "text/plain")
    public String home() {

        return """
                🏢 Employee HR Dashboard Backend is Running Successfully!

                ================= AUTH APIs =================
                POST   /api/auth/register        -> Register User
                POST   /api/auth/login           -> Login User

                ================= EMPLOYEE APIs =================
                POST   /employees                -> Add Employee
                GET    /employees                -> Get All Employees
                GET    /employees/{id}           -> Get Employee by ID
                PUT    /employees/{id}           -> Update Employee
                DELETE /employees/{id}           -> Delete Employee

                ================= DROPDOWN APIs =================
                GET    /employees/departments    -> Get Departments
                GET    /employees/positions      -> Get Positions
                GET    /employees/experiences    -> Get Experience Levels

                ================= STATUS =================
                Server is running successfully ✔
                """;
    }
}