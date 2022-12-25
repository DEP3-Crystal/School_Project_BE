package com.crystal.school.model;


import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.model.pivote.StudentGrade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sessions")
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    private List<SessionRegistration> sessionRegistrations = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    private List<StudentGrade> studentGrades = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    private List<SessionRating> sessionRatings = new ArrayList<>();

}
