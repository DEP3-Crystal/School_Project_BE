package com.crystal.school.dto_old;

import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Image profilePicture;
//    private DepartmentDto department;

//    private List<StudentRegistrationDto> studentRegistrations;
//    private List<StudentGradeDto> studentGrades;

}
