package com.crystal.school.dao;

import com.crystal.school.model.*;
import com.crystal.school.model.id.SessionRegistrationId;
import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.service.FakerService;
import com.github.javafaker.Faker;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FakerDataAccess {
    private static FakerDataAccess instance;
    private Faker faker = Faker.instance();
    private FakerService fakerService = FakerService.getInstance();
    private List<School> schools;
    private List<User> users;
    private List<Teacher> teachers;
    private List<Employee> employees;

    private List<StudentRegistration> studentRegistrations;
    private List<SessionRegistration> sessionRegistrations;

    public static FakerDataAccess getInstance() {
        if (instance == null)
            instance = new FakerDataAccess();
        return instance;
    }

    private Timestamp timestampUTCNow() {
        return Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    }

    public List<School> generateSchools(int numberOfSchools, int rooms, int sessions, int teacher, int students) {
        schools = new ArrayList<>();
        for (int i = 0; i < numberOfSchools; i++) {
            schools.add(generateSchool(rooms, sessions, teacher, students));
        }
        return schools;
    }

    public School generateSchool(int rooms, int sessions, int teacher, int students) {
        School school = new School(faker.random().nextInt(1), faker.address().streetAddress(), faker.name().lastName(), null);
        school.setRooms(generateRooms(school, rooms, sessions, teacher, students));
        return school;
    }

    private List<Room> generateRooms(School school, int num, int sessions, int teacher, int students) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            rooms.add(generateRoom(school, sessions, teacher, students));
        }
        return rooms;
    }

    private Room generateRoom(School school, int sessions, int teacher, int students) {
        Room room = new Room(faker.random().nextInt(1), faker.random().nextInt(1, 4), faker.random().nextInt(1, 500), faker.lorem().word(), school, null);
        room.setClassroom(generateClassroom(room, sessions, teacher, students));
        return room;
    }

    private Classroom generateClassroom(Room room, int sessions, int teachers, int students) {
        Classroom classroom = new Classroom(faker.random().nextInt(1), faker.random().nextInt(1, 30), room
                , null, null
        );
        classroom.setSessionRegistrations(generateSessionRegistrations(sessions, classroom, teachers, students));
        classroom.setStudentRegistrations(generateStudentRegistrations(classroom, students));
        return classroom;
    }

    private List<StudentRegistration> generateStudentRegistrations(Classroom classroom, int registrations) {
        studentRegistrations = new ArrayList<>();
        for (int i = 0; i < registrations; i++) {
            studentRegistrations.add(generateStudentRegistration(classroom));
        }
        return studentRegistrations;
    }

    private StudentRegistration generateStudentRegistration(Classroom classroom) {
        var student = generateUser();
        var stRegId = new StudentRegistrationId(student.getUserId(), classroom.getClassroomId());
        return new StudentRegistration(stRegId, timestampUTCNow(), classroom, student);
    }

    private List<SessionRegistration> generateSessionRegistrations(int number, Classroom classroom, int teachers, int students) {
        sessionRegistrations = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            sessionRegistrations.add(generateSessionRegistration(classroom, teachers, students));
        }
        return sessionRegistrations;
    }

    private SessionRegistration generateSessionRegistration(Classroom classroom, int teachers, int students) {

        int sessionId = faker.random().nextInt(1);
        SessionRegistrationId sessionRegistrationId = new SessionRegistrationId(sessionId, classroom.getClassroomId());
        return new SessionRegistration(sessionRegistrationId, timestampUTCNow(),
                timestampUTCNow(), generateSession(sessionId, teachers, students), classroom);
    }

    public Department generateDepartment(int sessions, int teachers, int users, Employee employee) {
        return new Department(faker.random().nextInt(1), faker.lorem().word(), employee, generateSessions(sessions, teachers, users),
                generateTeachers(teachers), generateUsers(users));
    }


    private List<Teacher> generateTeachers(int number) {
        teachers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            teachers.add(generateTeacher());
        }
        return teachers;
    }

    private Teacher generateTeacher() {
        return new Teacher(generateEmployee(), faker.lorem().word(), null);
    }

    private List<Session> generateSessions(int number, int teachers, int students) {
        List<Session> sessions = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            sessions.add(generateSession(teachers, students));
        }
        return sessions;
    }

    private Session generateSession(int id, int teachers, int students) {
        String[] level = {"advanced", "intermediate", "beginner"};
        String difficultyLevel = fakerService.random(level);
        var departmentOrganizer = generateEmployee();
        return new Session(id, faker.lorem().word(), faker.lorem().sentence(5),
                faker.random().nextBoolean(), difficultyLevel, faker.lorem().word(), generateDepartment(id, teachers, students, departmentOrganizer),
                getRegisteredSession(id), null, null
        );
    }

    private List<SessionRegistration> getRegisteredSession(int id) {
        return sessionRegistrations.stream()
                .filter(sessionRegistration -> sessionRegistration.getSessionRegistrationId().getSessionId() == id)
                .toList();
    }

    private Session generateSession(int teachers, int students) {
        int sessionId = faker.random().nextInt(1);
        return generateSession(sessionId, teachers, students);
    }

    public Employee generateEmployee() {
        return new Employee(generateUser(), faker.phoneNumber().phoneNumber(), faker.lorem().word(),
                fakerService.random(new String[]{"A", "T", "O", null}));
    }

    public Employee generateEmployee(User user) {
        return new Employee(user, faker.phoneNumber().phoneNumber(), faker.lorem().word(),
                fakerService.random(new String[]{"A", "T", "O", null}));
    }

    public List<User> generateUsers(int number) {
        users = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            users.add(generateUser());
        }
        return users;
    }

    public User generateUser() {
        return generateUser(faker.random().nextInt(1));
    }

    public User generateUser(int id) {
        String[] gender = {"M","F"};
        return new User(id, faker.name().firstName(), faker.name().lastName(),
                fakerService.email(), fakerService.random(gender), null, faker.lorem().sentence(5), faker.lorem().word(),
                faker.lorem().characters(20, 100), null,
                null, null, null, null
        );
    }


}
