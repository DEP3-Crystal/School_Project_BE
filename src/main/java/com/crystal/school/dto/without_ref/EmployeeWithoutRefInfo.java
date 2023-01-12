package com.crystal.school.dto.without_ref;

import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder(builderMethodName = "createEmployeeBuilder")
public class EmployeeWithoutRefInfo extends UserInfoDtoWithoutRef {

    @NotNull
    private String phoneNumber;

    @NotNull
    private String title;

    @NotNull
    private Timestamp hireDate;
    private BigDecimal salary;

    @Builder(builderMethodName = "createEmployeeBuilder")
    public EmployeeWithoutRefInfo(Integer id, @NotNull String firstName, @NotNull String lastName, @Size(max = 255) @NotNull String email, @NotNull Gender gender, String biography, Role role, Image profilePicture, String phoneNumber, String title, Timestamp hireDate, BigDecimal salary) {
        super(id, firstName, lastName, email, gender, biography, role, profilePicture);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.hireDate = hireDate;
        this.salary = salary;
    }
}
