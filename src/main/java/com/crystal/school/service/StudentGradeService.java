package com.crystal.school.service;

import com.crystal.school.dto.pivote.StudentGradeDto;
import com.crystal.school.dto.registration.StudentGradeDtoRegistration;
import com.crystal.school.exception.ResourceNotFoundException;
import com.crystal.school.mapper.StudentGradeMapper;
import com.crystal.school.model.Session;
import com.crystal.school.model.User;
import com.crystal.school.model.id.StudentGradeId;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.repository.SessionRepository;
import com.crystal.school.repository.StudentGradeRepository;
import com.crystal.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGradeService {
    private static final StudentGradeMapper mapper = StudentGradeMapper.Instance;
    @Autowired
    private StudentGradeRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public StudentGradeDtoRegistration saveStudentGrade(StudentGradeDto gradeDto) {

        StudentGrade savedGrade = repository.save(mapper.toStudentGrade(gradeDto));
        return toStudentGradeDtoNew(mapper.toStudentGradeDto(savedGrade));
    }

    public List<StudentGradeDto> saveStudentGrades(List<StudentGradeDto> gradeDtos) {
        List<StudentGrade> studentGrades = gradeDtos.stream().map(mapper::toStudentGrade).toList();
        return repository.saveAll(studentGrades).stream()
                .map(mapper::toStudentGradeDto).toList();
    }

    public List<StudentGradeDto> getStudentGrades() {
        return repository.findAll().stream().map(mapper::toStudentGradeDto).toList();
    }

    public StudentGradeDto getStudentGradeById(StudentGradeId id) {
        return mapper.toStudentGradeDto(repository.findById(id).orElse(null));
    }

    public List<StudentGradeDtoRegistration> getStudentGradeByStudentId(Integer id) {
        List<StudentGradeDto> grades = repository.findGradesByStudentId(id).stream()
                .map(mapper::toStudentGradeDto)
                .toList();
        return grades.stream()
                .map(this::toStudentGradeDtoNew)
                .toList();
    }

    private StudentGradeDtoRegistration toStudentGradeDtoNew(StudentGradeDto studentGrade) {
        Optional<Session> optionalSession = sessionRepository.findById(studentGrade.getStudentGradeId().getStudentId());
        Optional<User> userOptional = userRepository.findById(studentGrade.getStudentGradeId().getStudentId());
        if (optionalSession.isEmpty() || userOptional.isEmpty()) {
            return null;
        }
        Session session = optionalSession.get();
        User student = userOptional.get();
        return StudentGradeDtoRegistration.builder()
                .sessionName(session.getTitle())
                .sessionDescription(session.getDescription())
                .isOptional(session.getIsOptional())
                .grade(studentGrade.getGrade())
                .difficultyLevel(session.getDifficultyLevel())
                .studentFirstName(student.getFirstName())
                .studentLastName(student.getLastName())
                .build();

    }

    public void deleteAllStudentGrades() {
        repository.deleteAll();
    }

    public void deleteStudentGradeById(StudentGradeId id) {
        repository.deleteById(id);
    }

    public StudentGradeDto editStudentGrade(StudentGradeDto gradeDto) {
        if (!repository.existsById(gradeDto.getStudentGradeId()))
            throw new ResourceNotFoundException("Student grade " + gradeDto.getStudentGradeId() + " not found");
        StudentGrade savedGrade = repository.save(mapper.toStudentGrade(gradeDto));
        return mapper.toStudentGradeDto(savedGrade);
    }
}
