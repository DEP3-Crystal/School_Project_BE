package com.crystal.school.dto;

import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String biography;
//    private List<StudentRegistration> registrations;
//    private List<StudentGrade> studentGrades;
//    private List<SessionRating> sessionRatings;
//    private List<TeacherRating> teacherRatings;


}
