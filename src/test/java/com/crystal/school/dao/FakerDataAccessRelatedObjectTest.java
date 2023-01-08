package com.crystal.school.dao;

import com.crystal.school.model.Room;
import com.crystal.school.model.Session;
import com.crystal.school.model.Student;
import com.crystal.school.service.FakerDataAccessService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FakerDataAccessRelatedObjectTest {
    @Autowired
    static FakerDataAccessService fakerDataAccess;


    @BeforeEach
    void setUp() {
        fakerDataAccess.insertDummyData();
    }

    @Test
    void generateStudentsCompletedRelation() {
        List<Student> students = fakerDataAccess.getStudents();


        students.forEach(student -> {
            assertNotNull(student.getDepartment());

            assertNotNull(student.getStudentGrades());
            student.getStudentRegistrations().forEach(reg -> {
                assertNotNull(reg.getStudent());
                assertNotNull(reg.getStudentRegistrationId());
                assertNotNull(reg.getSession());
                assertEquals(student.getId(), reg.getStudentRegistrationId().getStudentId());
            });
            student.getStudentGrades().forEach(grade -> {
                assertNotNull(grade.getStudentGradeId());
                assertNotNull(grade.getStudent());
                assertNotNull(grade.getSession());
                assertEquals(student, grade.getStudent());
                assertNotNull(grade.getGrade());
                assertEquals(student.getId(), grade.getStudentGradeId().getStudentId());
            });
            student.getSessionRatings().forEach(rate -> {
                assertNotNull(rate.getSessionRatingId());
                assertNotNull(rate.getSession());
                assertNotNull(rate.getStudent());
                assertNotNull(rate.getRating());
                assertEquals(student.getId(), rate.getSessionRatingId().getStudentId());
            });
            student.getTeacherRatings().forEach(rate -> {
                assertEquals(student.getId(), rate.getTeacherRatingId().getStudentId());
                assertNotNull(rate.getTeacher());
                assertNotNull(rate.getRating());
                assertNotNull(rate.getStudent());
            });
        });
    }

    @Test
    void rooms() {
        List<Room> rooms = fakerDataAccess.getRooms();
        List<Room> classrooms = rooms.stream().filter(room -> room.getType().equalsIgnoreCase("classroom")).toList();
        classrooms.forEach(classroom -> {
            assertNotNull(classroom.getSessionRegistrations());
            //SessionRegistrations test
//            classroom.getSessionRegistrations().forEach(reg -> {
//                assertEquals(classroom.getRoomId(), reg.getSessionRegistrationId().getRoomId());
//                assertNotNull(reg.getSession());
//                assertNotNull(reg.getRoom());
//            });


        });
    }

    @Test
    void generateSessions_NothingNull() {
        List<Session> sessions = fakerDataAccess.getSessions();
        sessions.forEach(session -> {
//            assertNotNull(session.getSessionRegistrations());
            assertNotNull(session.getDepartment());
            //SessionRegistrations test
//            session.getSessionRegistrations().forEach(reg -> {
//                assertEquals(session.getId(), reg.getSessionRegistrationId().getSessionId());
//                assertNotNull(reg.getSession());
//                assertNotNull(reg.getRoom());
//            });
            // test that studentRegistrations is all good
            session.getStudentGrades().forEach(grade -> {
                assertEquals(session.getId(), grade.getStudentGradeId().getSessionId());
                assertNotNull(grade.getStudent());
                assertEquals(session, grade.getSession());
            });
            // Test session
            session.getSessionRatings().forEach(rate -> {
                assertEquals(session.getId(), rate.getSessionRatingId().getSessionId());
                assertNotNull(rate.getStudent());
                assertNotNull(rate.getRating());
                assertEquals(session, rate.getSession());
            });
        });
    }

    @Test
    void teacherRating() {
        var teacherRatings = fakerDataAccess.getTeacherRatings();
        teacherRatings.forEach(rate -> {
            assertNotNull(rate.getTeacherRatingId());
            assertNotNull(rate.getTeacher());
            assertNotNull(rate.getRating());
            assertNotNull(rate.getStudent());
        });
    }


}
