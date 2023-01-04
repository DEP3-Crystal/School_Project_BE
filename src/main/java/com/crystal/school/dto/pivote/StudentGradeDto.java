package com.crystal.school.dto.pivote;

import com.crystal.school.dto.UserInfoDto;
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
    private UserInfoDto student;
//    private SessionDto session;
}