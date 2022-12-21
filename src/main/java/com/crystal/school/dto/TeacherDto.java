package com.crystal.school.dto;


import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class TeacherDto {
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

    private String title;
    private Role role;
    private String credentials;

}
