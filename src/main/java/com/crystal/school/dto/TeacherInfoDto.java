package com.crystal.school.dto;

import com.crystal.school.dto.pivote.TeacherRatingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInfoDto extends EmployeeInfoDto {
    private String credentials;
    private Long ratingSum;
    private Integer ratingCount;
    private List<TeacherRatingDto> teacherRatings = new ArrayList<>();

}
