package com.crystal.school.dao;

import com.crystal.school.model.*;
import com.crystal.school.model.id.SessionRatingId;
import com.crystal.school.model.id.SessionRegistrationId;
import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.service.FakerService;
import com.crystal.school.service.PasswordService;
import com.github.javafaker.Faker;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class FakerDataAccess {
    private static FakerDataAccess instance;
    Random random = new Random();
    private Faker faker = Faker.instance();
    private FakerService fakerService = FakerService.getInstance();
    private final PasswordService passwordService = new PasswordService();
    private List<School> schools;
    private List<User> users;
    private List<Teacher> teachers;
    private List<Employee> employees;
    private List<StudentRegistration> studentRegistrations;
    private List<SessionRegistration> sessionRegistrations;
    private List<SessionRating> sessionRatings;
    private List<Session> sessions;

    public static FakerDataAccess getInstance() {
        if (instance == null)
            instance = new FakerDataAccess();
        return instance;
    }

    private int randomId() {
        return random.nextInt(Integer.MAX_VALUE);
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
        School school = new School(randomId(), faker.address().streetAddress(), faker.name().lastName(), null);
        school.setRooms(generateRooms(school, rooms, sessions, teacher, students));
        return school;
    }

    public List<Room> generateRooms(School school, int num, int sessions, int teacher, int students) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            rooms.add(generateRoom(school, sessions, teacher, students));
        }
        return rooms;
    }

    public Room generateRoom(School school, int sessions, int teacherNo, int students) {

        Integer floor = faker.random().nextInt(1, 4);
        Integer doorNumber = faker.random().nextInt(1, 500);
        String type = faker.lorem().word();
        Integer capacity = faker.random().nextInt(20, 30);
        Room room = new Room(randomId(), floor, doorNumber, type, capacity, school,
                null, null);
        sessionRegistrations = generateSessionRegistrations(sessions, room, teacherNo, students);
        studentRegistrations = generateStudentRegistrations(room, students);
        room.setSessionRegistrations(sessionRegistrations);
        room.setStudentRegistrations(studentRegistrations);
        return room;
    }


    public List<StudentRegistration> generateStudentRegistrations(Room room, int registrations) {
        studentRegistrations = new ArrayList<>();
        for (int i = 0; i < registrations; i++) {
            studentRegistrations.add(generateStudentRegistration(room));
        }
        return studentRegistrations;
    }

    public StudentRegistration generateStudentRegistration(Room room) {
        var student = generateUser();
        var stRegId = new StudentRegistrationId(student.getUserId(), room.getRoomId());
        return new StudentRegistration(stRegId, timestampUTCNow(), room, student);
    }

    public List<SessionRegistration> generateSessionRegistrations(int number, Room room, int teachers, int students) {
        sessionRegistrations = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            sessionRegistrations.add(generateSessionRegistration(room, teachers, students));
        }
        return sessionRegistrations;
    }

    public SessionRegistration generateSessionRegistration(Room room, int teachers, int students) {

        int sessionId = randomId();
        SessionRegistrationId sessionRegistrationId = new SessionRegistrationId(sessionId, room.getRoomId());
        return new SessionRegistration(sessionRegistrationId, timestampUTCNow(), generateSession(sessionId), room);
    }

    public Department generateDepartment(int sessions, int teachers, int users, Employee employee) {
        List<Session> sessionList = generateSessions(sessions, teachers, users);
        List<Teacher> teacherList = generateTeachers(teachers);
        List<User> userList = generateUsers(users);
        String name = faker.lorem().word();
        return new Department(randomId(), name, employee, sessionList,
                teacherList, userList);
    }


    public List<Teacher> generateTeachers(int number) {
        teachers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            teachers.add(generateTeacher());
        }
        return teachers;
    }

    public Teacher generateTeacher() {
        return new Teacher(generateEmployee(), faker.lorem().word(), null);
    }

    public List<Session> generateSessions(int number, int teachers, int students) {
        sessions = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            var id = randomId();
            sessions.add(generateSession(id));
        }
        return sessions;
    }

    public Session generateSession(int id) {
        String[] level = {"advanced", "intermediate", "beginner"};
        String difficultyLevel = fakerService.random(level);
        return new Session(id, faker.lorem().word(), faker.lorem().sentence(5),
                faker.random().nextBoolean(), difficultyLevel, faker.lorem().word(),timestampUTCNow(),timestampUTCNow(), null,
                getRegisteredSession(id), null, null
        );
    }

    private List<SessionRegistration> getRegisteredSession(int id) {
        if (sessionRegistrations == null)
            return null;
        return sessionRegistrations.stream()
                .filter(sessionRegistration -> sessionRegistration.getSessionRegistrationId().getSessionId() == id)
                .toList();
    }

    public Session generateSession() {
        int sessionId = randomId();
        return generateSession(sessionId);
    }

    public List<Employee> generateEmployees(int number) {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            employeeList.add(generateEmployee());
        }
        return employeeList;
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
        return generateUser(randomId());
    }

    public User generateUser(int id) {
        String[] genderList = {"M", "F"};
        String gender = fakerService.random(genderList);

        String biography = faker.lorem().sentence(5);

        String plainPassword = faker.lorem().word();
        String salt = passwordService.getSaltValue(25);
        String securePassword = passwordService.generateSecurePassword(plainPassword, salt);

        return new User(id, faker.name().firstName(), faker.name().lastName(),
                fakerService.email(), gender, null, biography, securePassword,
                salt, null, faker.random().nextInt(2),
                null, null, null, null
        );
    }


    public List<SessionRating> generateSessionRatings(int number) {
        sessionRatings = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            sessionRatings.add(generateSessionRatingUnrelated());
        }
        return sessionRatings;
    }

    public SessionRating generateSessionRatingUnrelated() {
        Session session = generateSession();
        User student = generateUser();

        var sessionRaringId = new SessionRatingId(session.getSessionId(), student.getUserId());
        byte rating = (byte) faker.random().nextInt(5);
        return new SessionRating(sessionRaringId, rating, student, session);
    }

    public SessionRating generateSessionRating(SessionRatingId ids) {
        Session session = sessions.stream()
                .filter(session1 -> session1.getSessionId().equals(ids.getSessionId()))
                .findFirst().orElseThrow();

        User student = users.stream().filter(st->st.getUserId() == ids.getStudentId())
                .findFirst().orElseThrow();

        byte rating = (byte) faker.random().nextInt(5);
        return new SessionRating(ids, rating, student, session);
    }

}
