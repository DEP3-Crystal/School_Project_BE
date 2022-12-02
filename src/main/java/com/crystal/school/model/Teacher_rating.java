package com.crystal.school.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher_rating")
public class Teacher_rating implements Serializable {
    @Id
    @Column(name = "student_id")
    private Integer student_id;
    @Id
    @Column(name = "teacher_id")
    private Integer teacher_id;
    @Column(name = "rating")
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
