package com.crystal.school.dto.without_ref;

import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDtoWithoutRef {

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
