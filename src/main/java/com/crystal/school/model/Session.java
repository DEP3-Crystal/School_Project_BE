package com.crystal.school.model;


import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.model.pivote.StudentGrade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sessions")
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
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;
    // TODO May occur stack OverFlow
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @JsonIgnore
    @OneToMany(mappedBy = "session")
    private List<SessionRegistration> sessionRegistrations;
    @OneToMany(mappedBy = "session")
    private List<StudentGrade> studentGrades;
    @OneToMany(mappedBy = "session")
    private List<SessionRating> sessionRatings;

}
