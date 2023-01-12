package com.crystal.school.dto.registration;

import com.crystal.school.dto.UserInfoDto;
import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder(builderMethodName = "createStudentBuilder")
public class StudentRegistrationDto extends UserInfoDto {
    private String password;

    @Builder(builderMethodName = "createStudentBuilder")
    public StudentRegistrationDto(Integer id, @Size(max = 255) @NotNull String firstName, @Size(max = 255) @NotNull String lastName, String fullName, @Size(max = 255) @NotNull String email, @NotNull Gender gender, String biography, Role role, Image profilePicture, Timestamp birthDate, String password) {
        super(id, firstName, lastName, fullName, email, gender, biography, role, profilePicture, birthDate);
        this.password = password;
    }
}
