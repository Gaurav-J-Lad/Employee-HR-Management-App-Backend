package com.gaurav.employeehrdashboardapp.repository;

import com.gaurav.employeehrdashboardapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}