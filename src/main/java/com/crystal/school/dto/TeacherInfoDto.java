package com.crystal.school.dto;

import com.crystal.school.dto.without_ref.DepartmentDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.TeacherRatingDtoWithoutRef;
import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "createTeacherBuilder")
public class TeacherInfoDto extends EmployeeInfoDto {

    private DepartmentDtoWithoutRef department;
    @Size(max = 255)
    @NotNull
    private String credentials;
    private List<TeacherRatingDtoWithoutRef> teacherRatings = new ArrayList<>();

}