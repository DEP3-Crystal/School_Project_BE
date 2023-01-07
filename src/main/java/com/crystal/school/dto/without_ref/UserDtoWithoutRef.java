package com.crystal.school.dto.without_ref;

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
public class UserDtoWithoutRef {

    private Integer id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @Size(max = 255)
    @NonNull
    private String email;

    @NonNull
    private Gender gender;

    private String biography;

    private Role role;

    private Image profilePicture;
}
