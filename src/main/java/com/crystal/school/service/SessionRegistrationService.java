package com.crystal.school.service;

import com.crystal.school.dto.pivote.SessionRegistrationDto;
import com.crystal.school.mapper.SessionRegistrationMapper;
import com.crystal.school.model.id.SessionRegistrationId;
import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.repository.SessionRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionRegistrationService {
    @Autowired
    private SessionRegistrationRepository sessionRegistrationRepository;

    public SessionRegistrationDto saveSessionRegistration(SessionRegistration sessionRegistration) {
        return SessionRegistrationMapper.Instance.toSessionRegistrationDto(sessionRegistrationRepository.save(sessionRegistration));
    }

    public List<SessionRegistrationDto> saveSessionsRegistrations(List<SessionRegistration> sessionRegistrations) {
        return sessionRegistrationRepository.saveAll(sessionRegistrations).stream().map(SessionRegistrationMapper.Instance::toSessionRegistrationDto).toList();
    }

    public List<SessionRegistrationDto> getSessionRegistrations() {
        return sessionRegistrationRepository.findAll().stream().map(SessionRegistrationMapper.Instance::toSessionRegistrationDto).toList();
    }

    public SessionRegistrationDto getSessionRegistrationById(SessionRegistrationId id) {
        return SessionRegistrationMapper.Instance.toSessionRegistrationDto(sessionRegistrationRepository.findById(id).orElse(null));
    }

    public void deleteAllSessionsRegistrations() {
        sessionRegistrationRepository.deleteAll();
    }

    public void deleteSessionRegistrationById(SessionRegistrationId id) {
        sessionRegistrationRepository.deleteById(id);
    }

    public SessionRegistrationDto editSessionRegistration(SessionRegistration sessionRegistration) {
        SessionRegistration existingSessionRegistration = sessionRegistrationRepository.findById(sessionRegistration.getSessionRegistrationId()).orElse(null);
        existingSessionRegistration.setSession(sessionRegistration.getSession());
        existingSessionRegistration.setRegDate(sessionRegistration.getRegDate());
        existingSessionRegistration.setRoom(sessionRegistration.getRoom());

        return SessionRegistrationMapper.Instance.toSessionRegistrationDto(sessionRegistrationRepository.save(existingSessionRegistration));
    }
}
