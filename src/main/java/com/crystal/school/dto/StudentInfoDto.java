package com.crystal.school.dto;

import com.crystal.school.dto.without_ref.DepartmentDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.SessionRatingDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentGradeDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentRegistrationDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.TeacherRatingDtoWithoutRef;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class StudentInfoDto extends UserInfoDto {

    private Integer grade;
    protected DepartmentDtoWithoutRef department;

    private List<StudentRegistrationDtoWithoutRef> studentRegistrations = new ArrayList<>();
    private List<StudentGradeDtoWithoutRef> studentGrades = new ArrayList<>();
    private List<SessionRatingDtoWithoutRef> sessionRatings = new ArrayList<>();
    private List<TeacherRatingDtoWithoutRef> teacherRatings = new ArrayList<>();

}
