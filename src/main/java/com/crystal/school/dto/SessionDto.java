package com.crystal.school.dto;

import com.crystal.school.model.Department;
import com.crystal.school.model.Room;
import com.crystal.school.model.Teacher;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionDto {

    private Integer id;

    private String title;

    private String description;

    private Boolean isOptional;

    private String difficultyLevel;
    private String keywords;
    @NotNull
    private Timestamp start;
    @NotNull
    private Timestamp end;

    private Teacher teacher;
    private DepartmentWithoutRef department;

    private RoomWithoutRef room;
    private Timestamp regDate = new Timestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

    private List<StudentGradeWithoutRef> studentGrades = new ArrayList<>();
    private List<SessionRatingWithoutRef> sessionRatings = new ArrayList<>();
    private List<StudentRegistrationWithoutRef> studentRegistrations = new ArrayList<>();
}
