package com.crystal.school.controller;

import com.crystal.school.dto.EmployeeDto;
import com.crystal.school.dto.EmployeeRegistration;
import com.crystal.school.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee/{id}")
    public EmployeeDto getWorkerById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllWorkers() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public String addWorker(@RequestBody EmployeeRegistration employee) {
        employeeService.createEmployee(employee);
        return "Added successfully";
    }

    @PostMapping("/workers")
    public String addWorkers(@RequestBody List<EmployeeRegistration> workers) {
        employeeService.createEmployees(workers);
        return "Added successfully";
    }

    @PutMapping("/employee")
    public String updateWorker(@RequestBody EmployeeRegistration employee) {
        employeeService.updateEmployee(employee);
        return "Updated successfully";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteWorkerById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted successfully";
    }

    @DeleteMapping("/employee")
    public String deleteWorker(@RequestBody EmployeeRegistration employee) {
        employeeService.deleteEmployee(employee);
        return "Deleted successfully";
    }

    @DeleteMapping("/workers")
    public String deleteWorkers() {
        employeeService.deleteAllEmployees();
        return "Deleted successfully all workers";
    }

}
