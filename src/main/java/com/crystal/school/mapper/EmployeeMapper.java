package com.crystal.school.mapper;

import com.crystal.school.dto_old.EmployeeInfoDto;
import com.crystal.school.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper Instance = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeInfoDto employeeDto);

    EmployeeInfoDto toEmployeeDto(Employee employee);
}
