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
public class DepartmentDto {
    private Integer departmentId;
    private String name;
    private EmployeeDto employee;
    //    private List<SessionDto> sessions;
    private List<TeacherDto> teachers;
    private List<UserDto> users;
}
