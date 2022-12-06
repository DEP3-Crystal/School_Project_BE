package com.crystal.school.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "student_registration")
public class StudentRegistration implements Serializable{
    @Id
    @Column(name = "student_id")
    private Integer studentId;
    @Id
    @Column(name = "classroom_id")
    private Integer classroomId;
    @Column(name = "datetime")
    private Timestamp datetime;
    @ManyToOne
    private Classroom classroom;
    @ManyToOne
    private Student student;

}
