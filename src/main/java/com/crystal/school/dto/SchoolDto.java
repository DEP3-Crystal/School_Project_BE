package com.crystal.school.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SchoolDto {
    private Integer schoolId;
    private String location;
    private String name;
    private List<RoomDto> rooms;
}
