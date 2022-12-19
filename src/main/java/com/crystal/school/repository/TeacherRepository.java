package com.crystal.school.repository;

import com.crystal.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByFirstName(String firstName);
}
