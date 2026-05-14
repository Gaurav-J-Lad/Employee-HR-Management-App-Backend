package com.gaurav.employeehrdashboardapp.service;

// ================= IMPORTS =================

import com.gaurav.employeehrdashboardapp.entity.Department;
import com.gaurav.employeehrdashboardapp.entity.Employee;
import com.gaurav.employeehrdashboardapp.entity.Experience;
import com.gaurav.employeehrdashboardapp.entity.Position;

import java.util.List;

// ================= EMPLOYEE SERVICE INTERFACE =================
// Defines business operations for Employee management
// Includes CRUD + dropdown data services for HR module

public interface EmployeeService {

    // =========================================================
    // ADD EMPLOYEE
    // Saves a new employee record
    // =========================================================

    Employee add(Employee e);

    // =========================================================
    // UPDATE EMPLOYEE
    // Updates existing employee by ID
    // =========================================================

    Employee update(Long id, Employee e);

    // =========================================================
    // DELETE EMPLOYEE
    // Removes employee record by ID
    // =========================================================

    void delete(Long id);

    // =========================================================
    // GET ALL EMPLOYEES
    // Returns list of all employees
    // =========================================================

    List<Employee> getAll();

    // =========================================================
    // GET EMPLOYEE BY ID
    // Returns single employee details
    // =========================================================

    Employee getById(Long id);

    // ================= DROPDOWN SERVICES =================
    // Used to populate UI dropdowns in frontend forms

    // =========================================================
    // GET ALL DEPARTMENTS
    // =========================================================

    List<Department> getDepartments();

    // =========================================================
    // GET ALL POSITIONS
    // =========================================================

    List<Position> getPositions();

    // =========================================================
    // GET ALL EXPERIENCE LEVELS
    // =========================================================

    List<Experience> getExperiences();
}