package com.crystal.school.repository;

import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.id.StudentRegistrationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, StudentRegistrationId> {
}
