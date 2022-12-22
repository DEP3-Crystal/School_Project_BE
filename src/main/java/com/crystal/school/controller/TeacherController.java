package com.crystal.school.controller;

import com.crystal.school.dto.TeacherDto;
import com.crystal.school.model.Teacher;
import com.crystal.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @GetMapping("/teacher/{id}")
    public TeacherDto getTeacherById(@PathVariable Integer id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/teachers")
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping("/teacher")
    public String addTeacher(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "Teacher added successfully";
    }

//    @PostMapping("/teachers")
//    public String addTeachers(@RequestBody List<Teacher> teachers) {
//        teacherService.save(teachers);
//        return "Added successfully";
//    }

    @PutMapping("/teacher")
    public String updateTeacher(@RequestBody Teacher teacher) {
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
