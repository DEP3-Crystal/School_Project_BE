package com.crystal.school.service;

import com.crystal.school.dto.pivote.StudentGradeDto;
import com.crystal.school.mapper.StudentGradeMapper;
import com.crystal.school.model.id.StudentGradeId;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.repository.StudentGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGradeService {
    @Autowired
    private StudentGradeRepository repository;

    public StudentGradeDto saveSudentGrade(StudentGrade studentGrade) {
        return StudentGradeMapper.Instance.toStudentGradeDto(repository.save(studentGrade));
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
