package com.crystal.school.dao;

import com.crystal.school.model.*;
import com.crystal.school.model.pivote.TeacherRating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FakerDataAccessTest {
    FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();

    @Test
    void generateUser() {
        User user = fakerDataAccess.generateUser();
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    void generateUsers() {
        int number = 5_000;
        var user = fakerDataAccess.generateUsers(number);
        assertEquals(number, user.size());
    }

    @Test
    void generateEmployees() {
        int number = 5_000;
        var employee = fakerDataAccess.generateEmployees(number);
        assertEquals(number, employee.size());

    }

    @Test
    void generateTeachers() {
        int number = 50_000;
        var teachers = fakerDataAccess.generateTeachers(number);
        assertEquals(number, teachers.size());
    }

    @Test
    void generateSessions() {
        int number = 100;
        var session = fakerDataAccess.generateSessions(number);

        assertEquals(number, session.size());
    }

    @Test
    void generateDepartment() {
        Employee employee = fakerDataAccess.generateEmployee();
        Department department = fakerDataAccess.generateDepartment();
        assertNotNull(department);
    }

    @Test
    void generateRooms() {
        int num = 500;
        List<Room> rooms = fakerDataAccess.generateRooms(num);
        assertEquals(num, rooms.size());

    }


    @Test
    void generateTeacherRatings() {
        List<Teacher> teachers = fakerDataAccess.generateTeachers(20);
        List<User> users = fakerDataAccess.generateUsers(500);
        fakerDataAccess.setTeachers(teachers);
        fakerDataAccess.setStudents(users);
        List<TeacherRating> sessionRatings = fakerDataAccess.generateTeacherRatings(500);
        Assertions.assertTrue(true);
    }


}
