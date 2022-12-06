package com.crystal.school.repository;

import com.crystal.school.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Integer> {
    Worker findByFirstName(String firstName);
}
