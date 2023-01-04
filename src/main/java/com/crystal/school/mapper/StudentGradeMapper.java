package com.crystal.school.mapper;

import com.crystal.school.dto.pivote.StudentGradeDto;
import com.crystal.school.dto.pivote.StudentGradeDtoNew;
import com.crystal.school.model.Session;
import com.crystal.school.model.User;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.repository.SessionRepository;
import com.crystal.school.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class StudentGradeMapper {
    public static final StudentGradeMapper Instance = Mappers.getMapper(StudentGradeMapper.class);

    public abstract StudentGrade toStudentGrade(StudentGradeDto studentGradeDto);

    public abstract StudentGradeDto toStudentGradeDto(StudentGrade studentGrade);

}
