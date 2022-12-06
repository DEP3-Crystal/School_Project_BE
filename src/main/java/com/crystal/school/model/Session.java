package com.crystal.school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    @Column(name = "keywords")
    private String keywords;
    @OneToMany
    private List<StudentGrades> studentGrades;
    @OneToMany
    private  List<SessionRating> sessionRatings;
    @OneToMany
    private List<SessionRegistration> sessionRegistrations;
    @ManyToOne
    private Department department;

}
