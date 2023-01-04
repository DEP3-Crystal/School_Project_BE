package com.crystal.school.service;

import com.crystal.school.dto.SessionDto;
import com.crystal.school.exception.ResourceNotFoundException;
import com.crystal.school.mapper.SessionMapper;
import com.crystal.school.model.Session;
import com.crystal.school.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    @Autowired
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
        return SessionMapper.Instance.toSessionDto(sessionRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public String deleteSessionById(Integer id) {
        sessionRepository.deleteById(id);
        return "Session  deleted: " + id;
    }


    public void deleteAllSessions() {
        sessionRepository.deleteAll();
    }

    public SessionDto editSession(Session session) {
        Session existingSession = sessionRepository.findById(session.getId()).orElseThrow(ResourceNotFoundException::new);
        return SessionMapper.Instance.toSessionDto(sessionRepository.save(existingSession));
    }
}
