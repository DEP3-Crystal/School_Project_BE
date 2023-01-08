package com.crystal.school.dto.without_ref;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithoutRefInfo extends UserInfoDtoWithoutRef {

    @NotNull
    private String phoneNumber;

    @NotNull
    private String title;

    @NotNull
    private Timestamp hireDate;
    private BigDecimal salary;

}
