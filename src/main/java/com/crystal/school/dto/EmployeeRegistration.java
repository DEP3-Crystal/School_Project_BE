package com.crystal.school.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeRegistration extends EmployeeDto {
    private String password;
}
