package com.crystal.school.repository;


import com.crystal.school.model.TeacherRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRatingRepository extends JpaRepository<TeacherRating,Integer> {
}
