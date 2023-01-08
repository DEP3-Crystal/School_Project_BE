package com.crystal.school.dto.without_ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoDtoWithoutRef extends UserInfoDtoWithoutRef {
    private Integer grade;
}
