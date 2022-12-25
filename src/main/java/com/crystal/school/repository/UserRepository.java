package com.crystal.school.repository;

import com.crystal.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT u.is_employee FROM users u WHERE u.user_id = :userId", nativeQuery = true)
    Boolean isEmployee(int userId);

}
