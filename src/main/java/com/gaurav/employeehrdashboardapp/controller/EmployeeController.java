package com.gaurav.employeehrdashboardapp.controller;
import com.gaurav.employeehrdashboardapp.entity.Department;
import com.gaurav.employeehrdashboardapp.entity.Employee;
import com.gaurav.employeehrdashboardapp.entity.Experience;
import com.gaurav.employeehrdashboardapp.entity.Position;
import com.gaurav.employeehrdashboardapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {


    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // ================= EMPLOYEE =================

    @PostMapping
    public Employee add(@RequestBody Employee e) {
        return service.add(e);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // ================= DROPDOWNS =================

    @GetMapping("/departments")
    public List<Department> departments() {
        return service.getDepartments();
    }

    @GetMapping("/positions")
    public List<Position> positions() {
        return service.getPositions();
    }

    @GetMapping("/experiences")
    public List<Experience> experiences() {
        return service.getExperiences();
    }
}