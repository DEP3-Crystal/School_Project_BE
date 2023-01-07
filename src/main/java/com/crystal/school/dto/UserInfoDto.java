package com.crystal.school.dto;

import com.crystal.school.model.Department;
import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

    private Integer id;

    @Size(max = 255)
    @NonNull
    private String firstName;

    @Size(max = 255)
    @NonNull
    private String lastName;

    @Size(max = 255)
    @NonNull
    private String email;

    @NonNull
    private Gender gender;

    private String biography;


    @NonNull
    private String password;

    @NonNull
    private String salt;
    private Role role;

    private Image profilePicture;
    private DepartmentWithoutRef department;

    private List<StudentRegistrationWithoutRef> studentRegistrations = new ArrayList<>();

    private List<StudentGradeWithoutRef> studentGrades = new ArrayList<>();

    private List<SessionRatingWithoutRef> sessionRatings = new ArrayList<>();

    private List<TeacherRatingWithoutRef> teacherRatings = new ArrayList<>();

}
