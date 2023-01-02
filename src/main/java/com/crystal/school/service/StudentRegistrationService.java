package com.crystal.school.service;

import com.crystal.school.dto.pivote.StudentRegistrationDto;
import com.crystal.school.mapper.StudentRegistrationMapper;
import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationService {
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public StudentRegistrationDto saveStudentRegistration(StudentRegistration studentRegistration) {
        return StudentRegistrationMapper.Instance.toStudentRegistrationDto(studentRegistrationRepository.save(studentRegistration));
    }

    public List<StudentRegistrationDto> saveStudentRegistrations(List<StudentRegistration> studentRegistrations) {
        return studentRegistrationRepository.saveAll(studentRegistrations).stream().map(StudentRegistrationMapper.Instance::toStudentRegistrationDto).toList();
    }

    public List<StudentRegistrationDto> getStudentRegistrations() {
        return studentRegistrationRepository.findAll().stream().map(StudentRegistrationMapper.Instance::toStudentRegistrationDto).toList();
    }

    public StudentRegistrationDto getStudentRegistrationById(StudentRegistrationId id) {
        return StudentRegistrationMapper.Instance.toStudentRegistrationDto(studentRegistrationRepository.findById(id).orElse(null));
    }

    public void deleteStudentRegistration(StudentRegistration studentRegistration) {
        studentRegistrationRepository.delete(studentRegistration);
    }

    public void deleteAllStudentRegistrations() {
        studentRegistrationRepository.deleteAll();
    }

    public void deleteStudentRegistrationById(StudentRegistrationId id) {
        studentRegistrationRepository.deleteById(id);
    }

    public StudentRegistrationDto editStudentRegistration(StudentRegistration studentRegistration) {
        StudentRegistration existingStudentRegistration = studentRegistrationRepository.findById(studentRegistration.getStudentRegistrationId()).orElse(null);
        existingStudentRegistration.setStudentRegistrationId(studentRegistration.getStudentRegistrationId());
        existingStudentRegistration.setRoom(studentRegistration.getRoom());
        existingStudentRegistration.setRegDate(studentRegistration.getRegDate());
        existingStudentRegistration.setRoom(studentRegistration.getRoom());
        return StudentRegistrationMapper.Instance.toStudentRegistrationDto(studentRegistrationRepository.save(existingStudentRegistration));
    }


}
