package com.crystal.school.dto.without_ref;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherInfoDtoWithoutRef extends EmployeeWithoutRefInfo {

    @NotNull
    private String credentials;


}