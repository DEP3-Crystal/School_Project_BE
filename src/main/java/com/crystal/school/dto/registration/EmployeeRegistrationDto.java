package com.crystal.school.dto.registration;

import com.crystal.school.dto.EmployeeInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeRegistrationDto extends EmployeeInfoDto {
    private String password;
}
