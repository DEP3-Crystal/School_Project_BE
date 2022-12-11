package com.crystal.school.service;

import com.crystal.school.model.StudentRegistration;
import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationService {
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public StudentRegistration saveStudentRegistration(StudentRegistration studentRegistration){
        return studentRegistrationRepository.save(studentRegistration);
    }
    public List<StudentRegistration> saveStudentRegistrations(List<StudentRegistration> studentRegistrations){
        return studentRegistrationRepository.saveAll(studentRegistrations);
    }

    public List<StudentRegistration> getStudentRegistrations(){
        return studentRegistrationRepository.findAll();
    }
    public StudentRegistration getStudentRegistrationById(StudentRegistrationId id){
        return  studentRegistrationRepository.findById(id).orElse(null);
    }
    public void deleteStudentRegistration(StudentRegistration studentRegistration){
        studentRegistrationRepository.delete(studentRegistration);
    }
    public void deleteAllStudentRegistrations(){
         studentRegistrationRepository.deleteAll();
    }
    public void deleteStudentRegistrationById(StudentRegistrationId id) {
        studentRegistrationRepository.deleteById(id);
    }

    public StudentRegistration editStudentRegistration(StudentRegistration studentRegistration){
        StudentRegistration existingStudentRegistration = studentRegistrationRepository.findById(studentRegistration.getStudentRegistrationId()).orElse(null);
        existingStudentRegistration.setStudentRegistrationId(studentRegistration.getStudentRegistrationId());
        existingStudentRegistration.setClassroom(studentRegistration.getClassroom());
        existingStudentRegistration.setDatetime(studentRegistration.getDatetime());
        existingStudentRegistration.setClassroom(studentRegistration.getClassroom());
        return studentRegistrationRepository.save(existingStudentRegistration);
    }


}
