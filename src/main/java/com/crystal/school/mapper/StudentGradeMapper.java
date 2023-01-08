package com.crystal.school.mapper;

import com.crystal.school.dto.pivote.StudentGradeDto;
import com.crystal.school.model.pivote.StudentGrade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class StudentGradeMapper {
    public static final StudentGradeMapper Instance = Mappers.getMapper(StudentGradeMapper.class);

    public abstract StudentGrade toStudentGrade(StudentGradeDto studentGradeDto);

    public abstract StudentGradeDto toStudentGradeDto(StudentGrade studentGrade);

}
