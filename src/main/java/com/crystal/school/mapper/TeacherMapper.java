package com.crystal.school.mapper;

import com.crystal.school.dto.TeacherInfoDto;
import com.crystal.school.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper Instance = Mappers.getMapper(TeacherMapper.class);

    Teacher teacher(TeacherInfoDto teacherDto);

    TeacherInfoDto teacherDto(Teacher teacher);
}
