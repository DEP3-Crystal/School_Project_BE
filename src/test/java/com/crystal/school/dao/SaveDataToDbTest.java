package com.crystal.school.dao;

import com.crystal.school.model.*;
import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SaveDataToDbTest {
    FakerDataAccess fakerAccess = FakerDataAccess.getInstance();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private SessionRatingRepository sessionRatingRepository;
    @Autowired
    private TeacherRatingRepository teacherRatingIdRepository;


    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private SessionRegistrationRepository sessionRegistrationRepository;

    @Test
    void insertStudents() {
        List<User> users = fakerAccess.generateUsers(500);
        List<User> users1 = userRepository.saveAll(users);
        Assertions.assertTrue(true);
    }

    @Test
    void insertTeachers() {
        List<Teacher> teachers = fakerAccess.generateTeachers(500);
        List<Teacher> teachers1 = teacherRepository.saveAll(teachers);
        Assertions.assertTrue(true);

    }

    @Test
    void insertDepartments() {
        List<Department> departments = fakerAccess.generateDepartments(500);
        departmentRepository.saveAll(departments);
        Assertions.assertTrue(true);
    }

    @Test
    void insertRooms() {
        List<Room> rooms = fakerAccess.generateRooms(500);
        roomRepository.saveAll(rooms);
        Assertions.assertTrue(true);
    }

    @Test
    void insertSessions() {
        List<Session> sessions = fakerAccess.generateSessions(500);
        sessionRepository.saveAll(sessions);
        Assertions.assertTrue(true);
    }

    @Test
    void insertSessionRegistrations() {
        List<SessionRegistration> sessionRegistrations = fakerAccess.generateSessionRegistrations(500);
//        sessionRegistrationRepository.saveAll(sessionRegistrations);
        Assertions.assertTrue(true);
    }

    @Test
    void insertSchool() {
        School school = fakerAccess.generateSchool();
        schoolRepository.save(school);
        Assertions.assertTrue(true);
    }

    @Test
    void insertSchools() {
        List<School> schools = fakerAccess.generateSchools(5);
        schoolRepository.saveAll(schools);
        Assertions.assertTrue(true);
    }

}
