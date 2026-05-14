package com.gaurav.employeehrdashboardapp.service;

// ================= IMPORTS =================

import com.gaurav.employeehrdashboardapp.entity.Department;
import com.gaurav.employeehrdashboardapp.entity.Employee;
import com.gaurav.employeehrdashboardapp.entity.Experience;
import com.gaurav.employeehrdashboardapp.entity.Position;
import com.gaurav.employeehrdashboardapp.repository.DepartmentRepository;
import com.gaurav.employeehrdashboardapp.repository.EmployeeRepository;
import com.gaurav.employeehrdashboardapp.repository.ExperienceRepository;
import com.gaurav.employeehrdashboardapp.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// ================= SERVICE IMPLEMENTATION =================
// Handles all business logic for Employee CRUD operations
// and dropdown (Department, Position, Experience) data

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // ================= REPOSITORIES =================
    // Used for database operations

    private final EmployeeRepository repo;
    private final DepartmentRepository departmentRepo;
    private final PositionRepository positionRepo;
    private final ExperienceRepository experienceRepo;

    // =========================================================
    // CONSTRUCTOR INJECTION (BEST PRACTICE)
    // =========================================================

    public EmployeeServiceImpl(
            EmployeeRepository repo,
            DepartmentRepository departmentRepo,
            PositionRepository positionRepo,
            ExperienceRepository experienceRepo
    ) {
        this.repo = repo;
        this.departmentRepo = departmentRepo;
        this.positionRepo = positionRepo;
        this.experienceRepo = experienceRepo;
    }

    // ================= EMPLOYEE CRUD OPERATIONS =================

    // =========================================================
    // ADD EMPLOYEE
    // Sets relationships and saves employee
    // =========================================================

    @Override
    public Employee add(Employee e) {

        e.setDepartment(findDepartment(e.getDepartment()));
        e.setPosition(findPosition(e.getPosition()));
        e.setExperience(findExperience(e.getExperience()));

        return repo.save(e);
    }

    // =========================================================
    // UPDATE EMPLOYEE
    // Updates employee details by ID
    // =========================================================

    @Override
    public Employee update(Long id, Employee e) {

        Employee emp = repo.findById(id).orElse(null);

        if (emp != null) {

            emp.setName(e.getName());
            emp.setEmail(e.getEmail());
            emp.setSalary(e.getSalary());

            emp.setDepartment(findDepartment(e.getDepartment()));
            emp.setPosition(findPosition(e.getPosition()));
            emp.setExperience(findExperience(e.getExperience()));

            return repo.save(emp);
        }

        return null;
    }

    // =========================================================
    // DELETE EMPLOYEE
    // Removes employee record by ID
    // =========================================================

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // =========================================================
    // GET ALL EMPLOYEES
    // =========================================================

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    // =========================================================
    // GET EMPLOYEE BY ID
    // =========================================================

    @Override
    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ================= DROPDOWN DATA SERVICES =================
    // Used for frontend dropdown population (HR forms)

    @Override
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public List<Position> getPositions() {
        return positionRepo.findAll();
    }

    @Override
    public List<Experience> getExperiences() {
        return experienceRepo.findAll();
    }

    // ================= PRIVATE HELPER METHODS =================
    // Used to map incoming objects to existing DB records

    private Department findDepartment(Department d) {
        return departmentRepo.findAll()
                .stream()
                .filter(x -> x.getName().equalsIgnoreCase(d.getName()))
                .findFirst()
                .orElse(null);
    }

    private Position findPosition(Position p) {
        return positionRepo.findAll()
                .stream()
                .filter(x -> x.getLevel().equalsIgnoreCase(p.getLevel()))
                .findFirst()
                .orElse(null);
    }

    private Experience findExperience(Experience e) {
        return experienceRepo.findAll()
                .stream()
                .filter(x -> x.getRange().equalsIgnoreCase(e.getRange()))
                .findFirst()
                .orElse(null);
    }
}