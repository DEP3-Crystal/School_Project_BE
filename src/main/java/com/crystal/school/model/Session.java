package com.crystal.school.model;

import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sessions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Session {
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "is_optional")
    @NotNull
    private Boolean isOptional;
    @Column(name = "difficulty_level")
    private String difficultyLevel;
    @Column(name = "keywords")
    private String keywords;
    @NotNull
    @Column(name = "start_time")
    private Timestamp start;
    @NotNull
    @Column(name = "end_time")
    private Timestamp end;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "reg_date")
    private Timestamp regDate = new Timestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    private List<StudentGrade> studentGrades = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    private List<SessionRating> sessionRatings = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();
}
