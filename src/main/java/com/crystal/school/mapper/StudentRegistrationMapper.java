package com.crystal.school.mapper;


import com.crystal.school.dto.pivote.StudentRegistrationDto;
import com.crystal.school.model.pivote.StudentRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentRegistrationMapper {
    StudentRegistrationMapper Instance = Mappers.getMapper(StudentRegistrationMapper.class);

    StudentRegistration toStudentRegistration(StudentRegistrationDto studentRegistrationDto);

    StudentRegistrationDto toStudentRegistrationDto(StudentRegistration studentRegistration);
}
