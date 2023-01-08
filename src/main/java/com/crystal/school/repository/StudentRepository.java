package com.crystal.school.repository;

import com.crystal.school.model.Student;
import com.crystal.school.model.User;
import com.crystal.school.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Object> findByEmail(String email);
}
