package com.crystal.school.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_grades")

public class StudentGrades implements Serializable {
    @Id
    @Column(name = "student_id")
    private Integer studentId;
    @Id
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "grade")
    private Integer grade;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Session session;




}
