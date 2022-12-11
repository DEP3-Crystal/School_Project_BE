package com.crystal.school.repository;


import com.crystal.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<User,Integer> {
    User findByFirstName(String firstName);
}
