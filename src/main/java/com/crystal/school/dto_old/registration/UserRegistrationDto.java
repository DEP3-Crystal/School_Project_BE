package com.crystal.school.dto_old.registration;

import com.crystal.school.dto_old.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto extends UserInfoDto {
    private String password;
}
