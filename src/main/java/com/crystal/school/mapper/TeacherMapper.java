package com.crystal.school.mapper;

import com.crystal.school.dto.EmployeeDto;
import com.crystal.school.dto.TeacherDto;
import com.crystal.school.model.Employee;
import com.crystal.school.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper Instance  = Mappers.getMapper(TeacherMapper.class);

    Teacher teacher(TeacherDto teacherDto);
     TeacherDto teacherDto(Teacher teacher);
}
