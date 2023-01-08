package com.crystal.school.dto.without_ref;

import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDtoWithoutRef {

    protected Integer id;

    @NotNull
    protected String firstName;

    @NotNull
    protected String lastName;

    @Size(max = 255)
    @NotNull
    protected String email;

    @NotNull
    protected Gender gender;

    protected String biography;

    protected Role role;

    protected Image profilePicture;
}
