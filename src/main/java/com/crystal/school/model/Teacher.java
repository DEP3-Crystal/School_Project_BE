package com.crystal.school.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "teacher")
public class Teacher extends Worker {
    @Column(name = "title")
    private String title;
    @Column(name = "credentials")
    private String credentials;
    @Column(name = "department_id")
    private Integer department_id;
    @OneToMany
    @JoinColumn(name = "teacher_id")
    private Teacher_rating teacherRating;
    @OneToMany
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany
    private List<Classroom> classrooms;


}
