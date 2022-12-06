package com.crystal.school.repository;

import com.crystal.school.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
    Organizer findByFirstName(String firstName);
}
