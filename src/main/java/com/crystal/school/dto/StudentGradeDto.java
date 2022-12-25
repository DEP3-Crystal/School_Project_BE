package com.crystal.school.dto;

import com.crystal.school.model.id.StudentGradeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentGradeDto {
    private StudentGradeId studentGradeId;
    private Byte grade;
    private UserDto student;
//    private SessionDto session;
}
