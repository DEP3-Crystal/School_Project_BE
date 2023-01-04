package com.crystal.school.repository;


import com.crystal.school.model.id.StudentGradeId;
import com.crystal.school.model.pivote.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, StudentGradeId> {
    List<StudentGrade> findByStudentId(Integer studentId);
}
