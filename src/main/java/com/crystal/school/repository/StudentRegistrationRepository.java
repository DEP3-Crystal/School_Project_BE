package com.crystal.school.repository;

import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.model.pivote.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, StudentRegistrationId> {
    List<StudentRegistration> findAllByStudentId(Integer studentId);
}
