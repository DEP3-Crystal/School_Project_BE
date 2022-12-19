package com.crystal.school.repository;

import com.crystal.school.model.pivote.SessionRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRegistrationRepository extends JpaRepository<SessionRegistration, Integer> {
}
