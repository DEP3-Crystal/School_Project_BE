package com.crystal.school.dto;

import com.crystal.school.dto.without_ref.pivote.TeacherRatingDtoWithoutRef;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherInfoDto extends EmployeeInfoDto {

    @Size(max = 255)
    @NonNull
    private String credentials;
    private List<TeacherRatingDtoWithoutRef> teacherRatings = new ArrayList<>();
}