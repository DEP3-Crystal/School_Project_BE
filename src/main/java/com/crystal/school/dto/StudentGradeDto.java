package com.crystal.school.dto;

import com.crystal.school.model.Session;
import com.crystal.school.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentGradeDto {
//    private StudentGradeId studentGradeId;
    private Byte grade;
    private User student;
    private Session session;
}
