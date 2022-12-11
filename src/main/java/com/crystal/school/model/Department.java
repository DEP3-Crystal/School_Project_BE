package com.crystal.school.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department  {
    @Id
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Employee employee;

    @OneToMany(mappedBy = "department")
    private List<Session> sessions;
    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers;
    @OneToMany(mappedBy = "department")
    private List<User> users;

}
