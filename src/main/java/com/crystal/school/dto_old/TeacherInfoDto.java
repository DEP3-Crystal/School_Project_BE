package com.crystal.school.dto_old;

import com.crystal.school.dto_old.pivote.TeacherRatingDto;
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
    private List<TeacherRatingDto> teacherRatings = new ArrayList<>();

}
