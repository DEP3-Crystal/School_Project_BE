package com.crystal.school.service;

import com.crystal.school.dto.pivote.SessionRatingDto;
import com.crystal.school.mapper.SessionRatingMapper;
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

    public SessionRatingDto saveSessionRating(SessionRating sessionRating) {
        return SessionRatingMapper.Instance.toSessionRatingDto(sessionRatingRepository.save(sessionRating));
    }


    public List<SessionRatingDto> saveSessionRatings(List<SessionRating> sessionRatings) {
        return sessionRatingRepository.saveAll(sessionRatings).stream().map(SessionRatingMapper.Instance::toSessionRatingDto).toList();
    }

    public List<SessionRatingDto> getSessionRatings() {
        return sessionRatingRepository.findAll().stream().map(SessionRatingMapper.Instance::toSessionRatingDto).toList();
    }


    public SessionRatingDto getSessionRatingById(SessionRatingId id) {
        return SessionRatingMapper.Instance.toSessionRatingDto(sessionRatingRepository.findById(id).orElse(null));
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

    public SessionRatingDto editSessionRating(SessionRating sessionRating) {
        SessionRating existingSessionRating = sessionRatingRepository.findById(sessionRating.getSessionRatingId()).orElse(null);
        existingSessionRating.setRating(sessionRating.getRating());
        existingSessionRating.setStudent(sessionRating.getStudent());
        existingSessionRating.setSession(sessionRating.getSession());
        return SessionRatingMapper.Instance.toSessionRatingDto(sessionRatingRepository.save(existingSessionRating));
    }
}
