package com.crystal.school.dto_old;

import com.crystal.school.dto_old.pivote.SessionRatingDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionDto {
    private Integer id;
    private String title;
    private String description;
    private Timestamp start;
    private Timestamp end;
    //    private DepartmentDto department;

    @JsonProperty("isOptional")
    private Boolean isOptional;
    private RoomDto room;
    private Timestamp regDate;
    private String difficultyLevel;
    private String keywords;
    private TeacherInfoDto teacher;

    //    private List<StudentGradeDto> studentGrades;
    private List<SessionRatingDto> sessionRatings;

}
