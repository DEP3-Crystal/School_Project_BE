package com.crystal.school.dto.pivote;


import com.crystal.school.dto.without_ref.StudentInfoDtoWithoutRef;
import com.crystal.school.dto.without_ref.TeacherInfoDtoWithoutRef;
import com.crystal.school.model.id.TeacherRatingId;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherRatingDto {

    private TeacherRatingId teacherRatingId;

    @Min(1)
    @Max(5)
    @NotNull
    private Byte rating;

    private String comment;
    private TeacherInfoDtoWithoutRef teacher;
    private StudentInfoDtoWithoutRef student;

}
