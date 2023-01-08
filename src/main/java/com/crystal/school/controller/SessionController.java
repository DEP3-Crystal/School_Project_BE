package com.crystal.school.controller;

import com.crystal.school.dto.SessionDto;
import com.crystal.school.repository.SessionRepository;
import com.crystal.school.service.SessionService;
import com.crystal.school.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SessionController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private StudentRegistrationService studentRegistrationService;
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping("/sessions")
    public List<SessionDto> getSessionList() {
        return sessionService.getSessions();
    }

    @GetMapping("/sessions/{id}")
    public SessionDto getSessionById(@PathVariable Integer id) {
        return sessionService.getSessionById(id);
    }

    @GetMapping("/sessions/{id}/student")
    public List<SessionDto> getAllSessionByStudentId(@PathVariable Integer id) {
        return studentRegistrationService.findAllSessionsByStudentId(id);
    }

    @PostMapping("/session/add")
    public SessionDto addSession(@RequestBody SessionDto session) {
        return sessionService.saveSession(session);
    }

    @PostMapping("/sessions")
    public List<SessionDto> saveSessions(@RequestBody List<SessionDto> sessions) {
        return sessionService.saveSessions(sessions);
    }

    @PutMapping("/session")
    public SessionDto updateSession(@RequestBody SessionDto session) {
        return sessionService.editSession(session);
    }

    @DeleteMapping("/session/{id}")
    public String deleteSession(@PathVariable Integer id) {
        return sessionService.deleteSessionById(id);
    }

    @DeleteMapping("/sessions")
    public void deleteAllSessions() {
        sessionService.deleteAllSessions();
    }


}