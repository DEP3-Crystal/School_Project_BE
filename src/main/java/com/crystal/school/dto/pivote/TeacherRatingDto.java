package com.crystal.school.dto.pivote;


import com.crystal.school.dto.without_ref.TeacherInfoDtoWithoutRef;
import com.crystal.school.dto.without_ref.UserInfoDtoWithoutRef;
import com.crystal.school.model.id.TeacherRatingId;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherRatingDto {

    private TeacherRatingId teacherRatingId;

    @Min(1)
    @Max(5)
    @NonNull
    private Byte rating;

    private String comment;
    private TeacherInfoDtoWithoutRef teacher;
    private UserInfoDtoWithoutRef student;

}
