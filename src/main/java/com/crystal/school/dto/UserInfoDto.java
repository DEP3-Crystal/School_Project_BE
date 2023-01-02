package com.crystal.school.dto;

import com.crystal.school.dto.pivote.StudentRegistrationDto;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String biography;
    private Role role;
    private String profilePicture;
//    private DepartmentDto department;

    private List<StudentRegistrationDto> studentRegistrations;
//    private List<StudentGradeDto> studentGrades;

}
