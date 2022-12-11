package com.crystal.school.dao;

import com.crystal.school.model.*;
import com.crystal.school.model.pivote.SessionRating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FakerDataAccessTest {
    FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();

    @Test
    void generateUser() {
        User user = fakerDataAccess.generateUser();
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

    @Test
    void generateUsers() {
        var user = fakerDataAccess.generateUsers(5_000);
        Assertions.assertNotNull(user);
    }

    @Test
    void generateEmployees() {
        var employee = fakerDataAccess.generateEmployees(5_000);
        Assertions.assertNotNull(employee);
    }

    @Test
    void generateTeachers() {
        var teachers = fakerDataAccess.generateTeachers(50_000);
        Assertions.assertNotNull(teachers);
    }

    @Test
    void generateSessions() {
        var session = fakerDataAccess.generateSessions(100,10,200);
        Assertions.assertNotNull(session);
    }

    @Test
    void generateDepartment() {
        Employee employee = fakerDataAccess.generateEmployee();
        Department department = fakerDataAccess.generateDepartment(2, 100, 5_000, employee);
        Assertions.assertNotNull(department);
    }

    @Test
    void generateRooms() {
        List<Room> rooms = fakerDataAccess.generateRooms(null, 10, 2, 100, 5_000);
        Assertions.assertNotNull(rooms);
    }

    @Test
    void generateSchool() {
        List<School> schools = fakerDataAccess.generateSchools(2, 100, 20, 10, 100);
        Assertions.assertNotNull(schools);
    }


    //Pivots Models

    @Test
    void generateSessionRating() {
        List<SessionRating> sessionRatings = fakerDataAccess.generateSessionRatings(100);
        Assertions.assertNotNull(sessionRatings);
    }

}
