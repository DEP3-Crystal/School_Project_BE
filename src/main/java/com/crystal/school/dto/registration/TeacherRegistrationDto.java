package com.crystal.school.dto.registration;

import com.crystal.school.dto.TeacherInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeacherRegistrationDto extends TeacherInfoDto {
    private String password;
}
