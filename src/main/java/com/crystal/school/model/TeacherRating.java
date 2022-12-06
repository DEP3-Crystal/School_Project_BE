package com.crystal.school.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "teacher_rating")
public class TeacherRating implements Serializable {
    @Id
    @Column(name = "student_id")
    private Integer studentId;
    @Id
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "rating")
    private Integer rating;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Teacher teacher;
}
