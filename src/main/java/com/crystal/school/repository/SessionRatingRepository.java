package com.crystal.school.repository;

import com.crystal.school.model.SessionRating;
import com.crystal.school.model.id.SessionRatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRatingRepository extends JpaRepository<SessionRating, SessionRatingId> {
}
