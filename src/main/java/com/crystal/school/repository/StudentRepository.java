package com.crystal.school.repository;

import com.crystal.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByFirstName(String firstName);
}
