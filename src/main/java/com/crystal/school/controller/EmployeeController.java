package com.crystal.school.controller;

import com.crystal.school.model.Employee;
import com.crystal.school.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee/{id}")
    public Employee getWorkerById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/workers")
    public List<Employee> getAllWorkers() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public String addWorker(@RequestBody Employee employee) {
        employeeService.saveWorker(employee);
        return "Added successfully";
    }

    @PostMapping("/workers")
    public String addWorkers(@RequestBody List<Employee> workers) {
        employeeService.saveWorkers(workers);
        return "Added successfully";
    }

    @PutMapping("/employee")
    public String updateWorker(@RequestBody Employee employee) {
        employeeService.updateWorker(employee);
        return "Updated successfully";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteWorkerById(@PathVariable Integer id) {
        employeeService.deleteWorkerById(id);
        return "Deleted successfully";
    }

    @DeleteMapping("/employee")
    public String deleteWorker(@RequestBody Employee employee) {
        employeeService.deleteWorker(employee);
        return "Deleted successfully";
    }

    @DeleteMapping("/workers")
    public String deleteWorkers() {
        employeeService.deleteAllWorkers();
        return "Deleted successfully all workers";
    }

}
