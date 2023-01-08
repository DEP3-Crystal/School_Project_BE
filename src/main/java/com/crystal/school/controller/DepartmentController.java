package com.crystal.school.controller;


import com.crystal.school.dto.DepartmentDto;
import com.crystal.school.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<DepartmentDto> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public DepartmentDto getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/department")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartmentById(id);
    }

    @DeleteMapping("/departments")
    public void deleteDepartments() {
        departmentService.deleteAllDepartments();
    }

    @PostMapping("/add")
    public DepartmentDto addDepartment(@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }

    @PostMapping("/addSome")
    public List<DepartmentDto> addSomeDepartments(@RequestBody List<DepartmentDto> departments) {
        return departmentService.addDepartments(departments);
    }

    @PutMapping("/update")
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto department) {
        return departmentService.editDepartment(department);
    }
}
