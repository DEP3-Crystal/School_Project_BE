package com.crystal.school.controller;

import com.crystal.school.dto.SessionRegistrationDto;
import com.crystal.school.model.id.SessionRegistrationId;
import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.service.SessionRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionRegistrationController {
    @Autowired
    private SessionRegistrationService service;


    @GetMapping("/session-registrations")
    public List<SessionRegistrationDto> getSessionRegistrationsList() {
        //return fakerDataAccess.generateUsers(500);
        return service.getSessionRegistrations();
    }

    @GetMapping("/session-registration/{id}")
    public SessionRegistrationDto getSessionRegistrationById(@PathVariable SessionRegistrationId id) {
        return service.getSessionRegistrationById(id);
    }

    @PostMapping("/session-registration/add")
    public SessionRegistrationDto addSessionRegistration(@RequestBody SessionRegistration sessionRegistration) {
        return service.saveSessionRegistration(sessionRegistration);
    }

    @PostMapping("/sessions-registrations/add")
    public List<SessionRegistrationDto> addSessionRegistrations(@RequestBody List<SessionRegistration> sessionRegistrations) {
        return service.saveSessionsRegistrations(sessionRegistrations);
    }

    @PutMapping("/session-registration/edit")
    public SessionRegistrationDto updateSessionRegistration(@RequestBody SessionRegistration sessionRegistration) {
        return service.editSessionRegistration(sessionRegistration);
    }

    @DeleteMapping("/session-registration/{id}")
    public String deleteSessionRegistration(@PathVariable SessionRegistrationId id) {
        service.deleteSessionRegistrationById(id);
        return "Deleted successfully";
    }

    @DeleteMapping("/session-registrations/delete")
    public void deleteAllSessionsRegistrations() {
        service.deleteAllSessionsRegistrations();
    }


}
