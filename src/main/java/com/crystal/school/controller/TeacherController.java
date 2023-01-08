package com.crystal.school.controller;

import com.crystal.school.dto.TeacherInfoDto;
import com.crystal.school.dto.registration.TeacherRegistrationDto;
import com.crystal.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @GetMapping("/teacher/{id}")
    public TeacherInfoDto getTeacherById(@PathVariable Integer id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/teachers")
    public List<TeacherInfoDto> getAllTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping("/teacher")
    public String addTeacher(@RequestBody TeacherRegistrationDto teacher) {
        teacherService.createTeacher(teacher);
        return "TeacherRegistration added successfully";
    }

    @PutMapping("/teacher")
    public String updateTeacher(@RequestBody TeacherRegistrationDto teacher) {
        teacherService.updateTeacher(teacher);
        return "Updated successfully";
    }

    @DeleteMapping("/teacher/{id}")
    public String deleteTeacherById(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return "Deleted successfully";
    }


    @DeleteMapping("/teachers")
    public String deleteTeachers() {
        teacherService.deleteAllTeachers();
        return "Deleted successfully all teachers";
    }

}
