package com.crystal.school.controller;

import com.crystal.school.dto_old.EmployeeInfoDto;
import com.crystal.school.dto_old.registration.EmployeeRegistrationDto;
import com.crystal.school.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee/{id}")
    public EmployeeInfoDto getWorkerById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<EmployeeInfoDto> getAllWorkers() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public String addWorker(@RequestBody EmployeeRegistrationDto employee) {
        employeeService.createEmployee(employee);
        return "Added successfully";
    }

    @PostMapping("/workers")
    public String addWorkers(@RequestBody List<EmployeeRegistrationDto> workers) {
        employeeService.createEmployees(workers);
        return "Added successfully";
    }

    @PutMapping("/employee")
    public String updateWorker(@RequestBody EmployeeRegistrationDto employee) {
        employeeService.updateEmployee(employee);
        return "Updated successfully";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteWorkerById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return "Deleted successfully";
    }

    @DeleteMapping("/employee")
    public String deleteWorker(@RequestBody EmployeeRegistrationDto employee) {
        employeeService.deleteEmployee(employee);
        return "Deleted successfully";
    }

    @DeleteMapping("/workers")
    public String deleteWorkers() {
        employeeService.deleteAllEmployees();
        return "Deleted successfully all workers";
    }

}
