package com.crystal.school.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
@DiscriminatorValue("S")
public class Student extends User {
    @Column(name = "department_id")
    private Integer department_id;
    @Column(name = "teacher_id")
    private Integer teacher_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    @JoinColumn(name = "student_id")
    private List<Student_grades> studentGrades;
    @OneToMany
    private List<Teacher_rating> teacherRatings;


}
