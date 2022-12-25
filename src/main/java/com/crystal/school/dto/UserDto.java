package com.crystal.school.dto;

import com.crystal.school.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String biography;
    //    private List<StudentRegistrationDto> registrations;
//    private List<StudentGradeDto> studentGrades;

}
