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
    private static final SessionMapper mapper = SessionMapper.Instance;
    @Autowired
    private SessionRepository sessionRepository;

    public SessionDto saveSession(SessionDto session) {
        Session savedSession = sessionRepository.save(mapper.toSession(session));
        return mapper.toSessionDto(savedSession);
    }


    public List<SessionDto> saveSessions(List<SessionDto> sessionDtos) {
        List<Session> sessions = sessionDtos.stream().map(mapper::toSession).toList();
        List<Session> savedSessions = sessionRepository.saveAll(sessions);
        return savedSessions.stream()
                .map(SessionMapper.Instance::toSessionDto)
                .toList();
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

    public SessionDto editSession(SessionDto session) {
        if (!sessionRepository.existsById(session.getId()))
            throw new ResourceNotFoundException("session " + session.getId() + " does not exist");
        return SessionMapper.Instance.toSessionDto(sessionRepository.save(mapper.toSession(session)));
    }
}
