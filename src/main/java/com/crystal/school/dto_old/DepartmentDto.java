package com.crystal.school.dto_old;

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
    private EmployeeInfoDto employee;
    private List<TeacherInfoDto> teachers;
    private List<UserInfoDto> users;
    private List<SessionDto> sessions;
}
