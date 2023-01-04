package com.crystal.school.controller;

import com.crystal.school.dto.pivote.StudentGradeDto;
import com.crystal.school.dto.pivote.StudentGradeDtoNew;
import com.crystal.school.model.id.StudentGradeId;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.repository.StudentGradeRepository;
import com.crystal.school.service.StudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentGradesController {
    @Autowired
    private StudentGradeService service;
    @Autowired
    private StudentGradeRepository studentGradeRepository;


    @GetMapping("/student-grades")
    public List<StudentGradeDto> getStudentGradesList() {
        return service.getStudentGrades();
    }

    @GetMapping("/student-grade/{studentId},{gradeId}")
    public StudentGradeDto getStudentGradeById(@PathVariable Integer studentId, @PathVariable Integer gradeId) {
        return service.getStudentGradeById(new StudentGradeId(studentId, gradeId));
    }
    @GetMapping("/student-grade/{studentId}")
    public List<StudentGradeDtoNew> getStudentsGradeByStudentId(@PathVariable Integer studentId) {
        return service.getStudentGradeByStudentId(studentId);
    }

    @PostMapping("/student-grade/add")
    public StudentGradeDtoNew addStudentGrade(@RequestBody StudentGrade studentGrade) {
        return service.saveStudentGrade(studentGrade);
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
