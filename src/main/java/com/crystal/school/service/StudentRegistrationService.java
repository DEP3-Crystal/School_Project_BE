package com.crystal.school.service;

import com.crystal.school.dto.SessionDto;
import com.crystal.school.dto.pivote.StudentRegistrationDto;
import com.crystal.school.exception.ResourceNotFoundException;
import com.crystal.school.mapper.SessionMapper;
import com.crystal.school.mapper.StudentRegistrationMapper;
import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.repository.SessionRepository;
import com.crystal.school.repository.StudentRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentRegistrationService {
    private static final StudentRegistrationMapper mapper = StudentRegistrationMapper.Instance;
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public StudentRegistrationDto saveStudentRegistration(StudentRegistrationDto studentRegistrationDto) {
        StudentRegistration savedReg = studentRegistrationRepository.save(mapper.toStudentRegistration(studentRegistrationDto));
        return mapper.toStudentRegistrationDto(savedReg);
    }

    public List<StudentRegistrationDto> saveStudentRegistrations(List<StudentRegistrationDto> studentRegistrationDtos) {
        List<StudentRegistration> registrations = studentRegistrationDtos.stream().map(mapper::toStudentRegistration).toList();
        return studentRegistrationRepository.saveAll(registrations).stream()
                .map(mapper::toStudentRegistrationDto)
                .toList();
    }

    public List<StudentRegistrationDto> getStudentRegistrations() {
        return studentRegistrationRepository.findAll().stream()
                .map(mapper::toStudentRegistrationDto).toList();
    }

    public StudentRegistrationDto getStudentRegistrationById(StudentRegistrationId id) {
        return mapper.toStudentRegistrationDto(studentRegistrationRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public void deleteStudentRegistration(StudentRegistrationDto studentRegistration) {
        studentRegistrationRepository.deleteById(studentRegistration.getStudentRegistrationId());
    }

    public void deleteAllStudentRegistrations() {
        studentRegistrationRepository.deleteAll();
    }

    public void deleteStudentRegistrationById(StudentRegistrationId id) {
        studentRegistrationRepository.deleteById(id);
    }

    public StudentRegistrationDto editStudentRegistration(StudentRegistrationDto studentRegistration) {
        if(!studentRegistrationRepository.existsById(studentRegistration.getStudentRegistrationId()))
            throw new ResourceNotFoundException("Student registration " + studentRegistration.getStudentRegistrationId() + " does not") ;
        StudentRegistration savedReg = studentRegistrationRepository.save(mapper.toStudentRegistration(studentRegistration));
        return mapper.toStudentRegistrationDto(savedReg);
    }


    public List<SessionDto> findAllSessionsByStudentId(Integer id) {
        List<StudentRegistration> allByStudentId = studentRegistrationRepository.findAllByStudentId(id);
        var sessionsId = allByStudentId.stream().map(reg -> reg.getStudentRegistrationId().getSessionId()).toList();
        return sessionRepository.findAllById(sessionsId)
                .stream()
                .map(SessionMapper.Instance::toSessionDto)
                .toList();
    }
}
