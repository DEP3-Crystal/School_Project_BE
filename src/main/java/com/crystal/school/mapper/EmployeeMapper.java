package com.crystal.school.mapper;

import com.crystal.school.dto.EmployeeDto;
import com.crystal.school.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface EmployeeMapper {
    EmployeeMapper Instance  = Mappers.getMapper(EmployeeMapper.class);

    Employee employee(EmployeeDto employeeDto);

    EmployeeDto employeeDto(Employee employee);
}
