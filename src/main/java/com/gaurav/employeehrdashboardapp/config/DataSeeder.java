package com.gaurav.employeehrdashboardapp.config;
import com.gaurav.employeehrdashboardapp.entity.Department;
import com.gaurav.employeehrdashboardapp.entity.Experience;
import com.gaurav.employeehrdashboardapp.entity.Position;
import com.gaurav.employeehrdashboardapp.repository.DepartmentRepository;
import com.gaurav.employeehrdashboardapp.repository.ExperienceRepository;
import com.gaurav.employeehrdashboardapp.repository.PositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DepartmentRepository deptRepo;
    private final PositionRepository posRepo;
    private final ExperienceRepository expRepo;

    public DataSeeder(DepartmentRepository d,
                      PositionRepository p,
                      ExperienceRepository e) {
        this.deptRepo = d;
        this.posRepo = p;
        this.expRepo = e;
    }

    @Override
    public void run(String... args) {

        // =========================
        // Departments
        // =========================
        saveDepartmentIfNotExists("IT");
        saveDepartmentIfNotExists("HR");
        saveDepartmentIfNotExists("Finance");
        saveDepartmentIfNotExists("Sales");

        // =========================
        // Positions
        // =========================
        savePositionIfNotExists("Entry Level");
        savePositionIfNotExists("Intermediate");
        savePositionIfNotExists("Experienced");
        savePositionIfNotExists("Senior");
        savePositionIfNotExists("Manager");

        // =========================
        // Experience
        // =========================
        for (int i = 0; i <= 15; i++) {
            saveExperienceIfNotExists(i + " years");
        }

        saveExperienceIfNotExists("15+ years");

        System.out.println(" Default data seeded successfully");
    }

    // =========================
    // Helper Methods
    // =========================

    private void saveDepartmentIfNotExists(String name) {
        if (!deptRepo.existsByName(name)) {
            deptRepo.save(new Department(null, name));
        }
    }

    private void savePositionIfNotExists(String name) {
        if (!posRepo.existsByLevel(name)) {
            posRepo.save(new Position(null, name));
        }
    }

    private void saveExperienceIfNotExists(String range) {
        if (!expRepo.existsByRange(range)) {
            expRepo.save(new Experience(null, range));
        }
    }
}