package com.crystal.school.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student extends User {
//    @Column(name = "department_id")
//    private Integer departmentId;
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    @JoinColumn(name = "student_grades")
    private List<StudentGrades> studentGrades;
    @OneToMany
    @JoinColumn(name = "teacher_rating")
    private List<TeacherRating> teacherRatings;
    @OneToMany
    @JoinColumn(name = "student_registration")
    private List<StudentRegistration> studentRegistrations;
    @OneToMany
    @JoinColumn(name = "session_rating")
    private List<SessionRating> sessionRatings;



}
