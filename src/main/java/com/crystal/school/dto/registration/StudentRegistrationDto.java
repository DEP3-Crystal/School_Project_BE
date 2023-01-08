package com.crystal.school.dto.registration;

import com.crystal.school.dto.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDto extends UserInfoDto {
    private String password;
}
