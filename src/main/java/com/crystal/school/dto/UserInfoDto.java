package com.crystal.school.dto;

import com.crystal.school.dto.without_ref.DepartmentDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.SessionRatingDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentGradeDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentRegistrationDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.TeacherRatingDtoWithoutRef;
import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
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
    private String fullName = firstName + " " + lastName;
    @Size(max = 255)
    @NonNull
    private String email;

    @NonNull
    private Gender gender;

    private String biography;

    private Role role;

    private Image profilePicture;
    private DepartmentDtoWithoutRef department;

    private List<StudentRegistrationDtoWithoutRef> studentRegistrations = new ArrayList<>();

    private List<StudentGradeDtoWithoutRef> studentGrades = new ArrayList<>();

    private List<SessionRatingDtoWithoutRef> sessionRatings = new ArrayList<>();

    private List<TeacherRatingDtoWithoutRef> teacherRatings = new ArrayList<>();

}
