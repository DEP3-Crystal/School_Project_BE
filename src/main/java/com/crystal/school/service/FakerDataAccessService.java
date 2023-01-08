package com.crystal.school.service;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.model.*;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import com.crystal.school.repository.*;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class FakerDataAccessService {
    private final FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();
    private final FakerService fakerService = FakerService.getInstance();
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private UserRepository studentRepository;
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
    private TeacherRatingRepository teacherRatingRepository;


    @Autowired
    private RoomRepository roomRepository;


    @Autowired
    private StudentGradeRepository studentGradeRepository;
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;
    private List<School> schools;
    private List<Room> rooms;
    private List<Room> classrooms;
    private List<Department> departments;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Employee> employees;
    private List<StudentRegistration> studentRegistrations;
    private List<StudentGrade> studentGrades;
    private List<SessionRating> sessionRatings;
    private List<TeacherRating> teacherRatings;
    private List<Session> sessions;
    @Autowired
    private ImageRepository imageRepository;

    public void insertDummyData() {
        logger.info("generating dummy data...");
        fakerDataAccess.generateStudents(300);
        fakerDataAccess.generateEmployees(60);

        fakerDataAccess.generateTeachers(50);
        fakerDataAccess.generateDepartments(3);
        fakerDataAccess.generateStudentGrades(1000);
        fakerDataAccess.generateSessions(500);
        fakerDataAccess.generateStudentRegistrations(1000);
        fakerDataAccess.generateRooms(50);
        fakerDataAccess.generateSessionRatings(100);
        fakerDataAccess.generateTeacherRatings(1000);
        fakerDataAccess.generateSchools(3);

        initializeVariables();
        logger.info("inserting dummy data...");
        startInsertingValues();


    }

    private void initializeVariables() {
        students = fakerDataAccess.getStudents();
        teachers = fakerDataAccess.getTeachers();
        employees = fakerDataAccess.getEmployees();
        studentRegistrations = fakerDataAccess.getStudentRegistrations();
        studentGrades = fakerDataAccess.getStudentGrades();
//        sessionRegistrations = fakerDataAccess.getSessionRegistrations();
        sessionRatings = fakerDataAccess.getSessionRatings();
        teacherRatings = fakerDataAccess.getTeacherRatings();
        rooms = fakerDataAccess.getRooms();
        classrooms = fakerDataAccess.getClassrooms();
        departments = fakerDataAccess.getDepartments();
        schools = fakerDataAccess.getSchools();
        sessions = fakerDataAccess.getSessions();

    }

    /**
     * save all the values to db in order to keep the ids, except pivot tables
     */
    private void startInsertingValues() {
        imageRepository.saveAll(fakerDataAccess.getImages());
        studentRepository.saveAll(fakerDataAccess.getStudents());
        employeeRepository.saveAll(fakerDataAccess.getEmployees());
        teacherRepository.saveAll(fakerDataAccess.getTeachers());
        departmentRepository.saveAll(fakerDataAccess.getDepartments());
        sessionRepository.saveAll(fakerDataAccess.getSessions());
        roomRepository.saveAll(fakerDataAccess.getRooms());
        schoolRepository.saveAll(fakerDataAccess.getSchools());
        makeSchoolRelations();
    }


    /**
     * rooms cant exist without school
     */
    public void makeSchoolRelations() {

        double percentagePerSchool = 100.0 / schools.size(); // Percentage of rooms that should be assigned to each school
        schoolRepository.saveAll(schools);

        schools.forEach(school -> {
            List<Room> roomsOfSchool = fakerService.take(rooms, percentagePerSchool, room -> room.getSchool() == null);
            List<Department> depOfSchool = fakerService.randomList(departments, percentagePerSchool, department -> department.getSchool() == null);
            school.setDepartments(depOfSchool);
            school.setRooms(roomsOfSchool);
            //backwards compatibility
            depOfSchool.forEach(department -> department.setSchool(school));
            roomsOfSchool.forEach(room -> room.setSchool(school));
        });
        List<Room> rooms1 = schools.stream().flatMap(school -> school.getRooms().stream()).toList();
        roomRepository.saveAll(rooms1);
        departmentRepository.saveAll(departments);
        //Update Schools
        schoolRepository.saveAll(schools);

        logger.info("done with schools and rooms");
        makeRoomRelations();
    }


    public void makeRoomRelations() {
        //setting schools

        makeDepartmentRelations();
        makeSessionRelations();
        makeStudentRelations();
        roomRepository.saveAll(rooms);
    }


    /**
     *
     */
    public void makeDepartmentRelations() {

        double percentage = 100.0 / departments.size();

        departments.forEach(department -> {


            List<Teacher> teachersOfDepartment = fakerService.take(teachers, percentage, teacher -> teacher.getDepartment() == null);
            List<Student> studentsOfDepartment = fakerService.take(students, percentage, student -> student.getDepartment() == null);
            List<Session> sessionsOfDepartment = fakerService.take(sessions, percentage, session -> session.getDepartment() == null);

            var employee = fakerService.random(employees);

            // setting values
            department.setStudents(studentsOfDepartment);
            department.setEmployee(employee);
            department.setTeachers(teachersOfDepartment);
            department.setSessions(sessionsOfDepartment);
            // Updating values
            departmentRepository.save(department);
            employeeRepository.save(employee);

            // setting backwards compatibility
            studentsOfDepartment.forEach(student -> student.setDepartment(department));
            teachersOfDepartment.forEach(teacher -> teacher.setDepartment(department));
            sessionsOfDepartment.forEach(session -> session.setDepartment(department));
            // Updating values
            teacherRepository.saveAll(teachersOfDepartment);
            studentRepository.saveAll(studentsOfDepartment);
            sessionRepository.saveAll(sessionsOfDepartment);

        });

        logger.info("done saving departments");
    }

    /**
     * session cant leave without department
     */
    public void makeSessionRelations() {

        double percentage = 100.0 / sessions.size();
        sessions.forEach(session -> {


//            List<SessionRegistration> regOfSession = fakerService.randomList(sessionRegistrations, percentage, reg -> reg.getSession() == null);
            List<SessionRating> rateOfSession = fakerService.take(sessionRatings, percentage, rate -> rate.getSession() == null);
            // preparing all pivot classes
//            regOfSession.forEach(reg -> {
//                Room room = fakerService.random(classrooms, r -> r.getSessionRegistrations().isEmpty());
//                reg.setRoom(room);
//                reg.setSession(session);
//                //ids
//                reg.getSessionRegistrationId().setSessionId(session.getId());
//                reg.getSessionRegistrationId().setRoomId(room.getRoomId());
//
//                // backwards compatibility
//                room.getSessionRegistrations().add(reg);
//            });
            rateOfSession.forEach(rate -> {
                var student = fakerService.random(students, s -> s.getSessionRatings().isEmpty());
                rate.setStudent(student);
                rate.setSession(session);
                //ids
                rate.getSessionRatingId().setSessionId(session.getId());
                rate.getSessionRatingId().setStudentId(student.getId());
                // backwards compatibility
                student.getSessionRatings().add(rate);
            });
            Teacher teacher = fakerService.random(teachers);
            teacher.setDepartment(session.getDepartment());
            session.setTeacher(teacher);
            sessionRepository.save(session);
            Room room = fakerService.random(classrooms, r -> r.getSessionRegistrations().isEmpty());
            session.setRoom(room);
//            sessionRegistrationRepository.saveAll(regOfSession);
            //saved at student
            session.setSessionRatings(rateOfSession);
            sessionRatingRepository.saveAll(rateOfSession);

        });
        sessionRepository.saveAll(sessions);
        logger.info("done saving sessions");

    }

    private void makeStudentRelations() {
        double percentage = 100.0 / students.size();

        students.forEach(student -> {


            var registrationsOfStudent = fakerService.take(studentRegistrations, percentage, reg -> reg.getStudent() == null);
            var gradesOfStudent = fakerService.take(studentGrades, percentage, grade -> grade.getStudent() == null);
            var teacherRatingOfStudent = fakerService.randomList(teacherRatings, percentage, rate -> rate.getStudent() == null);

            // preparing all pivot classes
            registrationsOfStudent.forEach(reg -> {
                Session session = fakerService.random(sessions, r -> r.getStudentRegistrations().isEmpty());
                reg.setSession(session);
                reg.setStudent(student);
                //ids
                reg.getStudentRegistrationId().setStudentId(student.getId());
                reg.getStudentRegistrationId().setSessionId(session.getId());
                // backwards compatibility
                session.getStudentRegistrations().add(reg);
            });
            gradesOfStudent.forEach(grade -> {
                Session session = fakerService.random(sessions, s -> s.getStudentGrades().isEmpty());
                grade.setSession(session);
                grade.setStudent(student);
                //ids
                grade.getStudentGradeId().setStudentId(student.getId());
                grade.getStudentGradeId().setSessionId(session.getId());
                // backwards compatibility
                session.getStudentGrades().add(grade);
            });
            teacherRatingOfStudent.forEach(rate -> {
                Teacher teacher = fakerService.random(teachers, t -> t.getTeacherRatings().isEmpty());
                rate.setTeacher(teacher);
                rate.setStudent(student);
                //ids
                rate.getTeacherRatingId().setStudentId(student.getId());
                rate.getTeacherRatingId().setTeacherId(teacher.getId());
                // backwards compatibility
                teacher.getTeacherRatings().add(rate);
            });

            // setting values
            studentRepository.save(student);
            student.setStudentRegistrations(registrationsOfStudent);
            student.setStudentGrades(gradesOfStudent);
            student.setTeacherRatings(teacherRatingOfStudent);
            studentRegistrationRepository.saveAll(registrationsOfStudent);
            studentGradeRepository.saveAll(gradesOfStudent);
            teacherRatingRepository.saveAll(teacherRatingOfStudent);
        });
        studentRepository.saveAll(students);
        logger.info("done saving student and all his pivot tables");
    }
}
