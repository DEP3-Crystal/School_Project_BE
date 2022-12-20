package com.crystal.school.dto;

import com.crystal.school.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto extends UserDto{

    private String title;
    private Role role;
}
