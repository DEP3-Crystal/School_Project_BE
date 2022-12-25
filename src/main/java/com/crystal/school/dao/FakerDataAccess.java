package com.crystal.school.dao;

import com.crystal.school.model.*;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import com.crystal.school.model.id.*;
import com.crystal.school.model.pivote.*;
import com.crystal.school.repository.EmployeeRepository;
import com.crystal.school.service.FakerService;
import com.crystal.school.service.PasswordService;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Getter
@Setter
@Component
public class FakerDataAccess {

    private static FakerDataAccess instance;
    private final Faker faker = Faker.instance();
    private final FakerService fakerService = FakerService.getInstance();
    private final PasswordService passwordService = new PasswordService();
    private final Random random = new Random();
    private final String cls = "Classroom";
    private final List<String> roomsType = List.of(cls, cls, cls, cls, "Office", "Cafeteria", "Lab", "library", "Auditorium");
    private Sequence userSequence = new Sequence();
    private Sequence roomSequence = new Sequence();
    private Sequence departmentSequence = new Sequence();
    private Sequence sessionSequence = new Sequence();
    private Sequence schoolSequence = new Sequence();
    private List<School> schools;
    private List<Room> rooms;
    private List<Room> classrooms;
    private List<Department> departments;
    private List<User> students;
    private String password = "1234";
    private List<Teacher> teachers;
    private List<Employee> employees;
    private List<StudentRegistration> studentRegistrations;
    private List<StudentGrade> studentGrades;
    private List<SessionRegistration> sessionRegistrations;
    private List<SessionRating> sessionRatings;
    private List<TeacherRating> teacherRatings;
    private List<Session> sessions;
    @Autowired
    private EmployeeRepository employeeRepository;

    public static FakerDataAccess getInstance() {
        if (instance == null)
            instance = new FakerDataAccess();
        return instance;
    }


    private Timestamp timestampUTCNow() {
        return Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    }


    public List<School> generateSchools(int numberOfSchools) {
        schools = IntStream.range(0, numberOfSchools).mapToObj(i -> generateSchool()).toList();
        return schools;
    }

    public List<Room> getClassrooms() {
        if (classrooms == null)
            classrooms = rooms.stream().filter(room -> room.getType().equalsIgnoreCase("classroom"))
                    .toList();
        return classrooms;
    }

    public List<StudentGrade> generateStudentGrades(int noStudentGrades) {
        studentGrades = IntStream.range(0, noStudentGrades).mapToObj(i -> generateStudentGrade()).toList();
        return studentGrades;
    }

    private StudentGrade generateStudentGrade() {
        byte rate = faker.random().nextInt(0, 10).byteValue();
        return new StudentGrade(new StudentGradeId(), rate, null, null);
    }

    public School generateSchool() {
        return new School(schoolSequence.nextId(), faker.address().streetAddress(), faker.name().lastName(), new ArrayList<>());
    }

    public List<Room> generateRooms(int num) {
        rooms = IntStream.range(0, num).mapToObj(i -> generateRoom()).toList();
        return rooms;
    }

    /**
     * nulls id, school, sessionRegistratrion, studentRegistratrion
     */
    public Room generateRoom() {
        Integer floor = faker.random().nextInt(1, 4);
        Integer doorNumber = faker.random().nextInt(1, 500);
        String type = fakerService.random(roomsType);
        Integer capacity = faker.random().nextInt(20, 30);
        return new Room(roomSequence.nextId(), floor, doorNumber, type, capacity, null,
                new ArrayList<>(), new ArrayList<>());
    }

    public List<Department> generateDepartments(int noDepartments) {
        departments = IntStream.range(0, noDepartments).mapToObj(i -> generateDepartment()).toList();
        return departments;
    }


    public Department generateDepartment() {
        String name = faker.lorem().word();
        return new Department(departmentSequence.nextId(), name, null, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>());
    }

    public List<TeacherRating> generateTeacherRatings(int noTeachers) {
        teacherRatings = IntStream.range(0, noTeachers).mapToObj(i -> generateTeacherRating()).toList();
        return teacherRatings;
    }

    private TeacherRating generateTeacherRating() {
        User student = fakerService.random(students);
        Teacher teacher = fakerService.random(teachers);
        Byte rating = fakerService.random(List.of(1, 2, 3, 4, 5)).byteValue();
        return new TeacherRating(new TeacherRatingId(), rating, teacher, student);
    }

    public List<StudentRegistration> generateStudentRegistrations(int registrations) {
        studentRegistrations = IntStream.range(0, registrations).mapToObj(i -> generateStudentRegistration()).toList();
        return studentRegistrations;

    }

    public StudentRegistration generateStudentRegistration() {
        return new StudentRegistration(new StudentRegistrationId(), timestampUTCNow(), null, null);
    }

    public List<SessionRegistration> generateSessionRegistrations(int number) {
        sessionRegistrations = IntStream.range(0, number + 1).mapToObj(i -> generateSessionRegistration()).toList();
        return sessionRegistrations;
    }


    public List<Teacher> generateTeachers(int number) {
        teachers = IntStream.range(0, number).mapToObj(i -> generateTeacher()).toList();
        return teachers;
    }

    public Teacher generateTeacher() {
        return new Teacher(generateEmployee(), faker.lorem().word(), new ArrayList<>());
    }

    public List<Session> generateSessions(int number) {
        sessions = IntStream.range(0, number).mapToObj(i -> generateSession()).toList();
        return sessions;

    }

    public Session generateSession() {
        String[] level = {"advanced", "intermediate", "beginner"};
        String difficultyLevel = fakerService.random(Arrays.stream(level).toList());
        String keywords = faker.lorem().word();
        Boolean isOptional = faker.random().nextBoolean();
        return new Session(sessionSequence.nextId(), faker.lorem().word(), faker.lorem().sentence(5),
                isOptional, difficultyLevel, keywords, timestampUTCNow(), timestampUTCNow(),
                null,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );
    }

    /**
     * nulls session, room
     */
    public SessionRegistration generateSessionRegistration() {

        return new SessionRegistration(new SessionRegistrationId(), timestampUTCNow(), null, null);
    }


    public List<Employee> generateEmployees(int number) {
        employees = IntStream.range(0, number).mapToObj(i -> generateEmployee()).toList();
        return employees;
    }

    public Employee generateEmployee() {
        Role role = getRandomRole();
        return new Employee(generateUser(), faker.phoneNumber().phoneNumber(), faker.lorem().word(), role);
    }


    public List<User> generateUsers(int number) {
        students = IntStream.range(0, number + 1).mapToObj(i -> generateUser()).toList();
        return students;
    }

    /**
     * nulls id, department, studentRegistration, studentGrade, sessionRation, teacherRation
     */
    public User generateUser() {
        Gender[] genderList = {Gender.M, Gender.F};
        Gender gender = fakerService.random(Arrays.stream(genderList).toList());

        String biography = faker.lorem().sentence(5);
        String saltValue = passwordService.getSaltValue(30);
        password = passwordService.encryptPassword(this.password, saltValue);
        return new User(userSequence.nextId(), faker.name().firstName(), faker.name().lastName(),
                faker.internet().emailAddress(), gender, biography, password, saltValue,
                null,
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );
    }


    public List<SessionRating> generateSessionRatings(int number) {
        sessionRatings = IntStream.range(0, number + 1).mapToObj(i -> generateSessionRating()).toList();
        return sessionRatings;
    }

    public SessionRating generateSessionRating() {
        Session session = generateSession();
        User student = generateUser();

        byte rating = faker.random().nextInt(1, 6).byteValue();
        return new SessionRating(new SessionRatingId(), rating, student, session);
    }

    private Role getRandomRole() {
        Role[] roles = {Role.ADMIN, Role.TEACHER, Role.ORGANIZER, Role.NONE};
        return fakerService.random(Arrays.stream(roles).toList());
    }

}
