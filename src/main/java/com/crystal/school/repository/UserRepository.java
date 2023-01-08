package com.crystal.school.repository;

import com.crystal.school.model.User;
import com.crystal.school.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Boolean existsByEmail(String email);

    @Query(value = "SELECT u.role FROM users u WHERE u.id = :userId", nativeQuery = true)
    Role getRole(int userId);

//    @Modifying
//    @Query(value = "UPDATE users u SET u.role = :role WHERE u.user_id = :userId", nativeQuery = true)
//    void updateUserRole(int userId, String role);
//
//    @Modifying
//    @Query(value = "UPDATE users u SET u.role = :role WHERE u.user_id in ( :userId)", nativeQuery = true)
//    Optional<User> updateUsersRole(String role, Integer... userId);
}
