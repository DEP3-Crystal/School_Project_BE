package com.crystal.school.dto.without_ref;

import com.crystal.school.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithoutRef extends UserDtoWithoutRef {

    @NonNull
    private String phoneNumber;

    @NonNull
    private String title;

    @NonNull
    private Timestamp hireDate;
    private BigDecimal salary;

}
