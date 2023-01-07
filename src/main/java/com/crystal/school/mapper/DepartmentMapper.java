package com.crystal.school.mapper;

import com.crystal.school.dto_old.DepartmentDto;
import com.crystal.school.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper Instance = Mappers.getMapper(DepartmentMapper.class);

    Department toDepartment(DepartmentDto departmentDto);

    DepartmentDto toDepartmentDto(Department department);
}
