package com.crystal.school.dto;

import com.crystal.school.dto.without_ref.DepartmentDtoWithoutRef;
import com.crystal.school.dto.without_ref.RoomWithoutRef;
import com.crystal.school.dto.without_ref.TeacherInfoDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.SessionRatingDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentGradeDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentRegistrationDtoWithoutRef;
import com.crystal.school.model.Teacher;
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

    private TeacherInfoDtoWithoutRef teacher;
    private DepartmentDtoWithoutRef department;

    private RoomWithoutRef room;
    private Timestamp regDate = new Timestamp(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

    private List<StudentGradeDtoWithoutRef> studentGrades = new ArrayList<>();
    private List<SessionRatingDtoWithoutRef> sessionRatings = new ArrayList<>();
    private List<StudentRegistrationDtoWithoutRef> studentRegistrations = new ArrayList<>();
}
