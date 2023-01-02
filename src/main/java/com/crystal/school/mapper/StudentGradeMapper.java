package com.crystal.school.mapper;

import com.crystal.school.dto.pivote.StudentGradeDto;
import com.crystal.school.model.pivote.StudentGrade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentGradeMapper {
    StudentGradeMapper Instance = Mappers.getMapper(StudentGradeMapper.class);

    StudentGrade toStudentGrade(StudentGradeDto studentGradeDto);

    StudentGradeDto toStudentGradeDto(StudentGrade studentGrade);
}
