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
    private static final SessionRatingMapper mapper = SessionRatingMapper.Instance;

    public SessionRatingDto saveSessionRating(SessionRatingDto sessionRating) {
        SessionRating savedSession = sessionRatingRepository.save(mapper.toSessionRating(sessionRating));
        return mapper.toSessionRatingDto(savedSession);
    }


    public List<SessionRatingDto> saveSessionRatings(List<SessionRatingDto> sessionRatingDtos) {
        List<SessionRating> sessionRatings = sessionRatingDtos.stream().map(mapper::toSessionRating).toList();
        List<SessionRating> savedSessionRatings = sessionRatingRepository.saveAll(sessionRatings);
        return savedSessionRatings.stream()
                .map(mapper::toSessionRatingDto).toList();
    }

    public List<SessionRatingDto> getSessionRatings() {
        return sessionRatingRepository.findAll().stream().map(mapper::toSessionRatingDto).toList();
    }


    public SessionRatingDto getSessionRatingById(SessionRatingId id) {
        return mapper.toSessionRatingDto(sessionRatingRepository.findById(id).orElse(null));
    }

    public String deleteSessionRatingById(SessionRatingId id) {
        sessionRatingRepository.deleteById(id);
        return "Session Rating deleted: " + id;
    }

    public void deleteSessionRating(SessionRatingDto sessionRating) {
        sessionRatingRepository.deleteById(sessionRating.getSessionRatingId());
    }

    public void deleteAllSessionRatings() {
        sessionRatingRepository.deleteAll();
    }

    public SessionRatingDto editSessionRating(SessionRatingDto sessionRating) {
        if (!sessionRatingRepository.existsById(sessionRating.getSessionRatingId()))
            throw new IllegalArgumentException("Session Rating not found");
        return mapper.toSessionRatingDto(sessionRatingRepository.save(mapper.toSessionRating(sessionRating)));
    }
}
