package com.crystal.school.dto;

import com.crystal.school.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto {
    private Integer departmentId;
    private String name;
    private Employee employee;
//    private List<Session> sessions;
//    private List<Teacher> teachers;
//    private List<User> users;
}
