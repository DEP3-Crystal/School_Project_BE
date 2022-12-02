package com.crystal.school.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_grades")

public class Student_grades implements Serializable {
    @Id
    @Column(name = "student_id")
    private Integer student_id;
    @Id
    @Column(name = "session_id")
    private Integer session_id;
    @Column(name = "grade")
    private Integer grade;
    @OneToMany
    @JoinColumn(name = "student_id")
    private Student student;




}
