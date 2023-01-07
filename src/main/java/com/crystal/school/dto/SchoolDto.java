package com.crystal.school.dto;


import com.crystal.school.dto.without_ref.DepartmentDtoWithoutRef;
import com.crystal.school.dto.without_ref.RoomDtoWithoutRef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolDto {
    private Integer schoolId;
    private String location;
    private String name;
    private List<DepartmentDtoWithoutRef> departments = new ArrayList<>();
    private List<RoomDtoWithoutRef> rooms = new ArrayList<>();

}
