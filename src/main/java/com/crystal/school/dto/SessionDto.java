package com.crystal.school.dto;

import com.crystal.school.model.Department;

import com.crystal.school.model.pivote.SessionRegistration;
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
    private Department department;
    private List<SessionRegistration> sessionRegistrations;
//    private boolean isOptional;
//    private String difficultyLevel;
//    private String keywords;
//    private List<StudentGrade> studentGrades;
//    private List<SessionRating> sessionRatings;

}
