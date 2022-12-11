package com.crystal.school.repository;


import com.crystal.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentGradesRepository extends JpaRepository<User,Integer> {
}
