package com.crystal.school.service;

import com.crystal.school.dto.SessionDto;
import com.crystal.school.mapper.SessionMapper;
import com.crystal.school.model.Session;
import com.crystal.school.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    public SessionDto saveSession(Session session) {
        return SessionMapper.Instance.toSessionDto(sessionRepository.save(session));
    }


    public List<SessionDto> saveSessions(List<Session> sessions) {
        return sessionRepository.saveAll(sessions).stream().map(SessionMapper.Instance::toSessionDto).toList();
    }

    public List<SessionDto> getSessions() {
        return sessionRepository.findAll().stream().map(SessionMapper.Instance::toSessionDto).toList();
    }


    public SessionDto getSessionById(Integer id) {
        return SessionMapper.Instance.toSessionDto(sessionRepository.findById(id).orElse(null));
    }

    public String deleteSessionById(Integer id) {
        sessionRepository.deleteById(id);
        return "Session  deleted: " + id;
    }


    public void deleteAllSessions() {
        sessionRepository.deleteAll();
    }

    public SessionDto editSession(Session session) {
        Session existingSession = sessionRepository.findById(session.getSessionId()).orElse(null);
        existingSession.setSessionRegistrations(session.getSessionRegistrations());
        existingSession.setSessionRatings(session.getSessionRatings());
        existingSession.setDepartment(session.getDepartment());
        existingSession.setTitle(session.getTitle());
        existingSession.setDescription(session.getDescription());
        existingSession.setStartTime(session.getStartTime());
        existingSession.setEndTime(session.getEndTime());
        existingSession.setDifficultyLevel(session.getDifficultyLevel());
        return SessionMapper.Instance.toSessionDto(sessionRepository.save(existingSession));
    }
}
