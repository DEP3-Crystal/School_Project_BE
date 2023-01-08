package com.crystal.school.dto;

import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "createUserBuilder")
public class UserInfoDto {

    protected Integer id;

    @Size(max = 255)
    @NotNull
    protected String firstName;

    @Size(max = 255)
    @NotNull
    protected String lastName;
    protected String fullName;
    @Size(max = 255)
    @NotNull
    protected String email;
    @NotNull
    protected Gender gender;
    protected String biography;
    protected Role role;
    protected Image profilePicture;
    protected Timestamp birthDate;


    public String getFullName() {
        if (fullName == null) {
            return firstName + " " + lastName;
        }
        return fullName;
    }

}
