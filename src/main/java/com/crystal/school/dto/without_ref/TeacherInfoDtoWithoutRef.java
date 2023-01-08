package com.crystal.school.dto.without_ref;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherInfoDtoWithoutRef extends EmployeeWithoutRefInfo {

    @NonNull
    private String credentials;


}