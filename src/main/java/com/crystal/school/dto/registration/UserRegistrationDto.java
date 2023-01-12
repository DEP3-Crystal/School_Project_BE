package com.crystal.school.dto.registration;

import com.crystal.school.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(builderMethodName = "createUserRegBuilder")
public class UserRegistrationDto extends UserInfoDto {
    private String password;
}
