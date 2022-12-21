package com.crystal.school.controller;

import com.crystal.school.dto.SessionDto;
import com.crystal.school.model.Session;
import com.crystal.school.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping("/sessions")
    public List<SessionDto> getSessionList() {
        //return fakerDataAccess.generateUsers(500);
        return sessionService.getSessions();
    }

    @GetMapping("/sessions/{id}")
    public SessionDto getSessionById(@PathVariable Integer id) {
        return sessionService.getSessionById(id);
    }

    @PostMapping("/session/add")
    public SessionDto addSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }

    @PostMapping("/sessions")
    public List<SessionDto> saveSessions(@RequestBody List<Session> sessions) {
        return sessionService.saveSessions(sessions);
    }

    @PutMapping("/session")
    public SessionDto updateSession(@RequestBody Session session) {
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