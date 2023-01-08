package com.crystal.school.dto.without_ref;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDtoWithoutRef {
    private Integer departmentId;
    private String name;

}
