package com.gaurav.employeehrdashboardapp.repository;

import com.gaurav.employeehrdashboardapp.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
    boolean existsByLevel(String level);
}