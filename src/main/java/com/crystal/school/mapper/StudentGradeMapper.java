package com.crystal.school.mapper;

import com.crystal.school.dto.StudentGradeDto;
import com.crystal.school.dto.UserDto;
import com.crystal.school.model.User;
import com.crystal.school.model.pivote.StudentGrade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentGradeMapper {
    StudentGradeMapper Instance = Mappers.getMapper(StudentGradeMapper.class);

    StudentGrade toStudentGrade(StudentGradeDto studentGradeDto);

    StudentGradeDto toStudentGradeDto(StudentGrade studentGrade);
}
