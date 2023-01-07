package com.crystal.school.service;

import com.crystal.school.dto_old.pivote.StudentGradeDto;
import com.crystal.school.dto_old.pivote.StudentGradeDtoRegistration;
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
    @Autowired
    private StudentGradeRepository repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;
    public StudentGradeDtoRegistration saveStudentGrade(StudentGrade studentGrade) {
        return toStudentGradeDtoNew(repository.save(studentGrade));
    }

    public List<StudentGradeDto> saveStudentGrades(List<StudentGrade> studentGrades) {
        return repository.saveAll(studentGrades).stream().map(StudentGradeMapper.Instance::toStudentGradeDto).toList();
    }

    public List<StudentGradeDto> getStudentGrades() {
        return repository.findAll().stream().map(StudentGradeMapper.Instance::toStudentGradeDto).toList();
    }

    public StudentGradeDto getStudentGradeById(StudentGradeId id) {
        return StudentGradeMapper.Instance.toStudentGradeDto(repository.findById(id).orElse(null));
    }
    public List<StudentGradeDtoRegistration> getStudentGradeByStudentId(Integer id) {
        List<StudentGrade> grades = repository.findByStudentId(id);
        return grades.stream().map(this::toStudentGradeDtoNew).toList();
    }

    private StudentGradeDtoRegistration toStudentGradeDtoNew(StudentGrade studentGrade) {
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

    public StudentGradeDto editStudentGrade(StudentGrade studentGrade) {
        StudentGrade existingStudentGrade = repository.findById(studentGrade.getStudentGradeId()).orElse(null);
        existingStudentGrade.setGrade(studentGrade.getGrade());
        existingStudentGrade.setStudent(studentGrade.getStudent());
        existingStudentGrade.setSession(studentGrade.getSession());


        return StudentGradeMapper.Instance.toStudentGradeDto(repository.save(existingStudentGrade));
    }
}
