package com.gaurav.employeehrdashboardapp.repository;

import com.gaurav.employeehrdashboardapp.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    boolean existsByRange(String range);
}