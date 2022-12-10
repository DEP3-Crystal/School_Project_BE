package com.crystal.school.controller;

import com.crystal.school.model.Student;
import com.crystal.school.model.Worker;
import com.crystal.school.service.StudentService;
import com.crystal.school.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getStudents();
    }
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Added successfully";
    }
    @PostMapping("/students")
    public String addStudents(@RequestBody List<Student> students){
        studentService.saveStudents(students);
        return "Added successfully";
    }
    @PutMapping("/student")
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Updated successfully";
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
        return "Deleted successfully";
    }
    @DeleteMapping("/student")
    public String deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        return "Deleted successfully";
    }
    @DeleteMapping("/students")
    public String deleteStudents(){
        studentService.deleteAllStudents();
        return "Deleted successfully all students";
    }
}
