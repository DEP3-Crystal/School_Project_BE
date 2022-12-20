package com.crystal.school.dto;

import com.crystal.school.model.Employee;
import com.crystal.school.model.Session;
import com.crystal.school.model.Teacher;
import com.crystal.school.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private Employee employee;
//    private List<Session> sessions;
//    private List<Teacher> teachers;
//    private List<User> users;
}
