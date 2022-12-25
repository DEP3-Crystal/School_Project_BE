package com.crystal.school.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegistration extends UserDto {
    private String password;
}
