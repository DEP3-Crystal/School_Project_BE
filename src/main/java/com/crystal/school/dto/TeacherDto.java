package com.crystal.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto extends EmployeeDto {
    private String credentials;
    private List<TeacherRatingDto> teacherRatings = new ArrayList<>();

}
