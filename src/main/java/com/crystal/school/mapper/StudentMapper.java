package com.crystal.school.mapper;

import com.crystal.school.dto.StudentInfoDto;
import com.crystal.school.dto.registration.StudentRegistrationDto;
import com.crystal.school.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper Instance = Mappers.getMapper(StudentMapper.class);

    Student toStudent(StudentInfoDto userInfoDto);
    Student toStudent(StudentRegistrationDto userInfoDto);

    StudentInfoDto toStudentDto(Student user);
}
