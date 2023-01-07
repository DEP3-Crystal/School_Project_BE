package com.crystal.school.dto_old.registration;

import com.crystal.school.dto_old.TeacherInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeacherRegistrationDto extends TeacherInfoDto {
    private String password;
}
