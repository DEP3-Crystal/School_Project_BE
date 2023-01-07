package com.crystal.school.dto_old.registration;

import com.crystal.school.dto_old.EmployeeInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeRegistrationDto extends EmployeeInfoDto {
    private String password;
}
