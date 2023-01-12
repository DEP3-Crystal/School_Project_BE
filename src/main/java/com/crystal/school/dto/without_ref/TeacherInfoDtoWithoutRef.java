package com.crystal.school.dto.without_ref;

import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder(builderMethodName = "createTeacherBuilder")
public class TeacherInfoDtoWithoutRef extends EmployeeWithoutRefInfo {

    @NotNull
    private String credentials;

    @Builder(builderMethodName = "createTeacherBuilder")
    public TeacherInfoDtoWithoutRef(Integer id, String firstName, String lastName, String email, Gender gender, String biography, Role role, Image profilePicture, String phoneNumber, String title, Timestamp hireDate, BigDecimal salary, String credentials) {
        super(id, firstName, lastName, email, gender, biography, role, profilePicture, phoneNumber, title, hireDate, salary);
        this.credentials = credentials;
    }
}