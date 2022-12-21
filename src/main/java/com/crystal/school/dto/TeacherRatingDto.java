package com.crystal.school.dto;

import com.crystal.school.model.Teacher;
import com.crystal.school.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherRatingDto {

    //    private TeacherRatingId teacherRatingId;
    private Byte rating;
    private Teacher teacher;
    private User student;
}
