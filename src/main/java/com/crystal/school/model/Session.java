package com.crystal.school.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "session")
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "is_optional")
    private boolean isOptional;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    @Column(name = "keywords")
    private String keywords;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "session")
    private List<SessionRegistration> sessionRegistrations;
    @OneToMany(mappedBy = "session")
    private List<StudentGrade> studentGrades;
     @OneToMany(mappedBy = "session")
    private List<SessionRating> sessionRatings;

}
