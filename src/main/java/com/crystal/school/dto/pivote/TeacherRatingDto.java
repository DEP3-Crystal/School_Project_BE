package com.crystal.school.dto.pivote;

import com.crystal.school.dto.UserInfoDto;
import com.crystal.school.model.id.TeacherRatingId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherRatingDto {
    private TeacherRatingId teacherRatingId;
    private Byte rating;
    //    private TeacherDto teacher;
    private UserInfoDto student;
}
