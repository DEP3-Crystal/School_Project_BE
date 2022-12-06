package com.crystal.school.repository;

import com.crystal.school.model.StudentGrades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradesRepository extends JpaRepository<StudentGrades,Integer> {
}
