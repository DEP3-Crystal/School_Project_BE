package com.crystal.school.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeacherRegistration extends TeacherDto {
    private String password;
}
