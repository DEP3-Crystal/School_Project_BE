package com.crystal.school.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "createEmployeeBuilder")
public class EmployeeInfoDto extends UserInfoDto {

    @Size(max = 255)
    @NonNull
    private String phoneNumber;

    @Size(max = 255)
    @NonNull
    private String title;

    @NonNull
    private Timestamp hireDate;
    private BigDecimal salary;


}
