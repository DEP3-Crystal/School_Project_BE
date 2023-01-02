package com.crystal.school.dto;

import com.crystal.school.dto.pivote.SessionRatingDto;
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
    private Integer sessionId;
    private String title;
    private String description;
    private Timestamp startTime;
    private Timestamp endTime;
    //    private DepartmentDto department;
    private boolean isOptional;
    private String difficultyLevel;
    private String keywords;
    private Long ratingSum;
    private Integer ratingCount;

    //    private List<StudentGradeDto> studentGrades;
    private List<SessionRatingDto> sessionRatings;

}
