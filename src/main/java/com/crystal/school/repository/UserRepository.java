package com.crystal.school.repository;

import com.crystal.school.model.User;
import com.crystal.school.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT u.is_employee FROM users u WHERE u.user_id = :userId", nativeQuery = true)
    Role getRole(int userId);

}
