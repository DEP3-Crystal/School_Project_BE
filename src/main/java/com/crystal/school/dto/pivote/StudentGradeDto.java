package com.crystal.school.dto.pivote;


import com.crystal.school.dto.without_ref.SessionDtoWithoutRef;
import com.crystal.school.dto.without_ref.UserInfoDtoWithoutRef;
import com.crystal.school.model.id.StudentGradeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGradeDto {
    private StudentGradeId studentGradeId;
    private Byte grade;

    private UserInfoDtoWithoutRef student;

    private SessionDtoWithoutRef session;

}
