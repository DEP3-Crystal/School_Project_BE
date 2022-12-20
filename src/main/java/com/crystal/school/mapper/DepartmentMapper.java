package com.crystal.school.mapper;

import com.crystal.school.dto.DepartmentDto;

import com.crystal.school.model.Department;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper Instance  = Mappers.getMapper(DepartmentMapper.class);

    Department toDepartment(DepartmentDto departmentDto);

    DepartmentDto toDepartmentDto(Department department);
}
