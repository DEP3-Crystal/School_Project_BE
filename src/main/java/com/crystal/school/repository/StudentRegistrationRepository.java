package com.crystal.school.repository;

import com.crystal.school.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration,Integer> {
}
