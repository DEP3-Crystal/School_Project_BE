package com.crystal.school.repository;


import com.crystal.school.model.id.StudentGradeId;
import com.crystal.school.model.pivote.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, StudentGradeId> {
}
