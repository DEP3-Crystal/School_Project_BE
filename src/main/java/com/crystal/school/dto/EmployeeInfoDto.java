package com.crystal.school.dto;


import com.crystal.school.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfoDto extends UserInfoDto {
    private String phoneNumber;
    private String title;
    private Role role;
}
