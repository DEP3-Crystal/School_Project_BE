package com.crystal.school.mapper;

import com.crystal.school.dto.EmployeeDto;
import com.crystal.school.dto.UserDto;
import com.crystal.school.model.Employee;
import com.crystal.school.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper Instance = Mappers.getMapper(UserMapper.class);

    User user(UserDto userDto);

    UserDto userDto(User user);
}
