package com.crystal.school.dao;

import com.crystal.school.model.*;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import com.crystal.school.model.id.SessionRatingId;
import com.crystal.school.model.id.StudentGradeId;
import com.crystal.school.model.id.StudentRegistrationId;
import com.crystal.school.model.id.TeacherRatingId;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import com.crystal.school.repository.EmployeeRepository;
import com.crystal.school.repository.ImageRepository;
import com.crystal.school.repository.UserRepository;
import com.crystal.school.service.FakerService;
import com.crystal.school.service.ImageService;
import com.crystal.school.service.PasswordService;
import com.crystal.school.utill.DownloadManager;
import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
    String[] departmentsNames = {"Admissions", "Financial Aid", "Registrar",
            "Academic Affairs", "Student Affairs", "Student Services",
            "Library", "Athletics", "Alumni Relations", "IT (Information Technology)"};
    // url for random avatar
    private String randomAvatarRootUrl = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/";
    private Sequence userSequence = new Sequence();
    private Sequence roomSequence = new Sequence();
    private Sequence departmentSequence = new Sequence();
    private Sequence sessionSequence = new Sequence();
    private Sequence schoolSequence = new Sequence();
    private List<School> schools;
    private List<Room> rooms;
    private List<Room> classrooms;
    private List<Department> departments;
    private List<Student> students;
    private String password = "1234";
    private List<Teacher> teachers;
    private List<Employee> employees;
    private List<StudentRegistration> studentRegistrations;
    private List<StudentGrade> studentGrades;
    private List<SessionRating> sessionRatings;
    private List<TeacherRating> teacherRatings;
    private List<Session> sessions;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepository imageRepository;
    private List<Image> images = generateAvatars(20);

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

    public List<StudentGrade> generateStudentGrades(int noUserGrades) {
        studentGrades = IntStream.range(0, noUserGrades).mapToObj(i -> generateUserGrade()).toList();
        return studentGrades;
    }

    private StudentGrade generateUserGrade() {
        byte rate = faker.random().nextInt(0, 10).byteValue();
        return new StudentGrade(new StudentGradeId(), rate, null, null);
    }

    public School generateSchool() {
        Integer id = schoolSequence.nextId();
        String address = faker.address().streetAddress();
        String name = faker.name().lastName();
        return School.builder()
                .schoolId(id)
                .name(name)
                .location(address)
                .build();

    }

    public List<Room> generateRooms(int num) {
        rooms = IntStream.range(0, num).mapToObj(i -> generateRoom()).toList();
        return rooms;
    }

    /**
     * nulls id, school, sessionRegistratrion, studentRegistratrion
     */
    public Room generateRoom() {
        Integer id = roomSequence.nextId();
        Integer floor = faker.random().nextInt(1, 4);
        Integer doorNumber = faker.random().nextInt(1, 500);
        String type = fakerService.random(roomsType);
        Integer capacity = faker.random().nextInt(20, 30);

        return new Room(id, floor, doorNumber, type, capacity, null, new ArrayList<>());
    }

    public List<Department> generateDepartments(int noDepartments) {
        departments = IntStream.range(0, noDepartments).mapToObj(i -> generateDepartment()).toList();
        return departments;
    }

    public Department generateDepartment() {
        String name = fakerService.random(Arrays.stream(departmentsNames).toList());
        Integer id = departmentSequence.nextId();
        return new Department(id, name, null, null, new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>());
    }

    public List<TeacherRating> generateTeacherRatings(int noTeachers) {
        teacherRatings = IntStream.range(0, noTeachers).mapToObj(i -> generateTeacherRating()).toList();
        return teacherRatings;
    }

    private TeacherRating generateTeacherRating() {
        Student student = fakerService.random(students);
        Teacher teacher = fakerService.random(teachers);
        Byte rating = fakerService.random(List.of(1, 2, 3, 4, 5)).byteValue();
        TeacherRatingId id = new TeacherRatingId();
        return TeacherRating.builder()
                .teacherRatingId(id)
                .student(student)
                .teacher(teacher)
                .rating(rating)
                .build();
    }

    public List<StudentRegistration> generateStudentRegistrations(int registrations) {
        studentRegistrations = IntStream.range(0, registrations).mapToObj(i -> generateUserRegistration()).toList();
        return studentRegistrations;

    }

    public StudentRegistration generateUserRegistration() {
        return new StudentRegistration(new StudentRegistrationId(), timestampUTCNow(), null, null);
    }

    public List<Teacher> generateTeachers(int number) {
        teachers = IntStream.range(0, number).mapToObj(i -> generateTeacher()).toList();
        return teachers;
    }

    public Teacher generateTeacher() {

        Employee employee = generateEmployee();
        employee.setRole(Role.TEACHER);
        return new Teacher(employee, faker.lorem().word(), new ArrayList<>());
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
        Integer id = sessionSequence.nextId();
        String title = faker.lorem().word();
        String description = faker.lorem().sentence(15);

        return new Session(id, title, description,
                isOptional, difficultyLevel, keywords, timestampUTCNow(), timestampUTCNow(),
                null, null, null, timestampUTCNow(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );
    }

//    public List<SessionRegistration> generateSessionRegistrations(int number) {
//        sessionRegistrations = IntStream.range(0, number + 1).mapToObj(i -> generateSessionRegistration()).toList();
//        return sessionRegistrations;
//    }

    public List<Employee> generateEmployees(int number) {
        employees = new ArrayList<>(IntStream.range(0, number).mapToObj(i -> generateEmployee()).toList());
        return employees;
    }

    public Employee generateEmployee() {
        Role role = getRandomEmployeeRole();
        BigDecimal[] salarys = {new BigDecimal(1_000), new BigDecimal(1_500), new BigDecimal(1_200), new BigDecimal(1_600)};
        BigDecimal salary = fakerService.random(Arrays.stream(salarys).toList());
        User user = generateStudent();
        user.setRole(role);
        return new Employee(user, faker.phoneNumber().phoneNumber(), faker.lorem().word(), timestampUTCNow(), salary);
    }

    public List<Student> generateStudents(int number) {
        students = IntStream.range(0, number + 1)

                .mapToObj(i -> generateStudent()).toList();
        return students;
    }

    /**
     * nulls id, department, studentRegistration, studentGrade, sessionRation, teacherRation
     */
    public Student generateStudent() {
        Gender[] genderList = {Gender.M, Gender.F};
        Gender gender = fakerService.random(Arrays.stream(genderList).toList());

        String biography = faker.lorem().sentence(5);
        String salt = passwordService.getSaltValue(30);
        var securedPassword = passwordService.encryptPassword(this.password, salt);

        Integer id = userSequence.nextId();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String emailAddress = faker.internet().emailAddress();
        Integer grade = faker.random().nextInt(0, 10);
        var image = fakerService.random(images);

        Timestamp birthDate = fakerService.randomDateTime(1980);

        return Student.createStudentBuilder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(emailAddress)
                .biography(biography)
                .password(securedPassword)
                .salt(salt)
                .role(Role.STUDENT)
                .gender(gender)
                .profilePicture(image)
                .grade(grade)
                .studentGrades(new ArrayList<>())
                .studentRegistrations(new ArrayList<>())
                .sessionRatings(new ArrayList<>())
                .teacherRatings(new ArrayList<>())
                .birthDate(birthDate)
                .build();

    }

//    /**
//     * nulls session, room
//     */
//    public SessionRegistration generateSessionRegistration() {
//
//        return new SessionRegistration(new SessionRegistrationId(), timestampUTCNow(), null, null);
//    }

    public List<SessionRating> generateSessionRatings(int number) {
        sessionRatings = IntStream.range(0, number + 1).mapToObj(i -> generateSessionRating()).toList();
        return sessionRatings;
    }

    public SessionRating generateSessionRating() {
        Session session = generateSession();
        var student = generateStudent();

        byte rating = faker.random().nextInt(1, 6).byteValue();
        return new SessionRating(new SessionRatingId(), rating, student, session);
    }

    private Role getRandomEmployeeRole() {
        Role[] roles = {Role.ADMIN, Role.EMPLOYEE, Role.EMPLOYEE, Role.EMPLOYEE, Role.ORGANIZER, Role.ORGANIZER};
        return fakerService.random(Arrays.stream(roles).toList());
    }

    public List<Image> addNewProfilePictures(int number) {
        images.addAll(IntStream.range(0, number)
                .mapToObj(i -> generateProfilePicture()).toList());
        return images;
    }

    private Image generateProfilePicture() {
        Integer profileImageId = faker.random().nextInt(0, 1249);
        byte[] bytes = new DownloadManager().downloadFromURL(randomAvatarRootUrl + profileImageId + ".jpg");
        return new Image(null, "fake-avatar", bytes);
    }

    public List<Image> generateAvatars(int number) {

        images = new ArrayList<>(IntStream.range(0, number).mapToObj(i -> {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            return generateAvatar(firstName, lastName);
        }).toList());
        return images;
    }

    private Image generateAvatar(String firstname, String lastname) {
        byte[] bytes = new DownloadManager().downloadFromURL("https://ui-avatars.com/api/?name=" + firstname + "+" + lastname);
        return new Image(null, "fake-avatar", bytes);
    }




}
