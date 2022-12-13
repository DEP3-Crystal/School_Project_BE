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
        int number = 5_000;
        var user = fakerDataAccess.generateUsers(number);
        Assertions.assertEquals(number, user.size());
    }

    @Test
    void generateEmployees() {
        int number = 5_000;
        var employee = fakerDataAccess.generateEmployees(number);
        Assertions.assertEquals(number, employee.size());

    }

    @Test
    void generateTeachers() {
        int number = 50_000;
        var teachers = fakerDataAccess.generateTeachers(number);
        Assertions.assertEquals(number, teachers.size());
    }

    @Test
    void generateSessions() {
        int number = 100;
        var session = fakerDataAccess.generateSessions(number, 10, 200);
        Assertions.assertEquals(number, session.size());
    }

    @Test
    void generateDepartment() {
        Employee employee = fakerDataAccess.generateEmployee();
        Department department = fakerDataAccess.generateDepartment(2, 100, 5_000, employee);
        Assertions.assertNotNull(department);
    }

    @Test
    void generateRooms() {
        int num = 10;
        List<Room> rooms = fakerDataAccess.generateRooms(null, num, 2, 100, 5_000);
        Assertions.assertEquals(num, rooms.size());

    }

    @Test
    void generateSchool() {
        int numberOfSchools = 2;
        List<School> schools = fakerDataAccess.generateSchools(numberOfSchools, 100, 20, 10, 100);
        Assertions.assertEquals(numberOfSchools, schools.size());

    }


    //Pivots Models

    @Test
    void generateSessionRating() {
        List<SessionRating> sessionRatings = fakerDataAccess.generateSessionRatings(100);
        Assertions.assertNotNull(sessionRatings);
    }

}
