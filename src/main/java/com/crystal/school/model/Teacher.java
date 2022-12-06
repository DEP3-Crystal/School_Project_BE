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
    private Integer departmentId;
    @OneToMany
    private List<TeacherRating> teacherRatings;
    @OneToMany
    private List<Classroom> classrooms;
    @ManyToOne
    private Department department;



}
