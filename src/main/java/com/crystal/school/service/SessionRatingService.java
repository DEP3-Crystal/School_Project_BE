package com.crystal.school.service;

import com.crystal.school.model.id.SessionRatingId;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.repository.SessionRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionRatingService {
    @Autowired
    private SessionRatingRepository sessionRatingRepository;

    public SessionRating saveSessionRating(SessionRating sessionRating) {
        return sessionRatingRepository.save(sessionRating);
    }


    public List<SessionRating> saveSessionRatings(List<SessionRating> sessionRatings) {
        return sessionRatingRepository.saveAll(sessionRatings);
    }

    public List<SessionRating> getSessionRatings() {
        return sessionRatingRepository.findAll();
    }


    public SessionRating getSessionRatingById(SessionRatingId id) {
        return sessionRatingRepository.findById(id).orElse(null);
    }

    public String deleteSessionRatingById(SessionRatingId id) {
        sessionRatingRepository.deleteById(id);
        return "Session Rating deleted: " + id;
    }

    public void deleteSessionRating(SessionRating sessionRating) {
        sessionRatingRepository.delete(sessionRating);
    }

    public void deleteAllSessionRatings() {
        sessionRatingRepository.deleteAll();
    }

    public SessionRating editSessionRating(SessionRating sessionRating) {
        SessionRating existingSessionRating = sessionRatingRepository.findById(sessionRating.getSessionRatingId()).orElse(null);
        existingSessionRating.setRating(sessionRating.getRating());
        existingSessionRating.setStudent(sessionRating.getStudent());
        existingSessionRating.setSession(sessionRating.getSession());
        return sessionRatingRepository.save(existingSessionRating);
    }
}
