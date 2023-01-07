package com.crystal.school.dto.without_ref;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolDtoWithoutRef {
    private Integer schoolId;
    private String location;
    private String name;

}
