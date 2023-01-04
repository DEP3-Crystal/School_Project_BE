package com.crystal.school.controller;

import com.crystal.school.dto.pivote.StudentRegistrationDtoOld;
import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class StudentRegistrationController {
    @Autowired
    private StudentRegistrationService studentRegistrationService;

    @GetMapping("/student-registrations")
    public List<StudentRegistrationDtoOld> getAllStudentRegistrations() {
        return studentRegistrationService.getStudentRegistrations();
    }

    @GetMapping("/student-registrations/{id}")
    public StudentRegistrationDtoOld getStudentRegistrationById(@PathVariable StudentRegistrationId id) {
        return studentRegistrationService.getStudentRegistrationById(id);
    }

    @PostMapping("/student-registration")
    public String addStudentRegistration(@RequestBody StudentRegistration studentRegistration) {
        studentRegistrationService.saveStudentRegistration(studentRegistration);
        return "Added successfully";
    }

    @PostMapping("/student-registrations")
    public String addStudentRegistrations(List<StudentRegistration> studentRegistrations) {
        studentRegistrationService.saveStudentRegistrations(studentRegistrations);
        return "Added successfully";

    }

    @PutMapping("/student-registration")
    public String editStudentRegistration(@RequestBody StudentRegistration studentRegistration) {
        studentRegistrationService.editStudentRegistration(studentRegistration);
        return "Updated successfully";
    }

    @DeleteMapping("/student-registration/{id}")
    public String deleteStudentRegistrationById(@PathVariable StudentRegistrationId id) {
        studentRegistrationService.deleteStudentRegistrationById(id);
        return "Deleted successfully" + id;
    }

    @DeleteMapping("/student-registrations")
    public void deleteAll() {
        studentRegistrationService.deleteAllStudentRegistrations();
    }

    @DeleteMapping("/registration")
    public void deleteRegistration(@RequestBody StudentRegistration studentRegistration) {
        studentRegistrationService.deleteStudentRegistration(studentRegistration);
    }


}
