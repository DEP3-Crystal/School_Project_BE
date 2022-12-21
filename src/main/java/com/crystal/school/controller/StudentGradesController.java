package com.crystal.school.controller;

import com.crystal.school.dto.StudentGradeDto;
import com.crystal.school.model.id.StudentGradeId;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentGradesController {
    @Autowired
    private StudentGradeService service;


    @GetMapping("/student-grades")
    public List<StudentGradeDto> getStudentGradesList() {
        //return fakerDataAccess.generateUsers(500);
        return service.getStudentGrades();
    }

    @GetMapping("/student-grade/{id}")
    public StudentGradeDto getStudentGradeById(@PathVariable StudentGradeId id) {
        return service.getStudentGradeById(id);
    }

    @PostMapping("/student-grade/add")
    public StudentGradeDto addStudentGrade(@RequestBody StudentGrade studentGrade) {
        return service.saveSudentGrade(studentGrade);
    }

    @PostMapping("/student-grades/add")
    public List<StudentGradeDto> addStudentGrades(@RequestBody List<StudentGrade> studentGrades) {
        return service.saveStudentGrades(studentGrades);
    }

    @PutMapping("/student-grade/edit")
    public StudentGradeDto updateStudentGrade(@RequestBody StudentGrade studentGrade) {
        return service.editStudentGrade(studentGrade);
    }

    @DeleteMapping("/student-grade/{id}")
    public String deleteStudentGrade(@PathVariable StudentGradeId id) {
        service.deleteStudentGradeById(id);
        return "Deleted successfully";
    }

    @DeleteMapping("/student-grades/delete")
    public void deleteAllStudentGrades() {
        service.deleteAllStudentGrades();
    }
}
