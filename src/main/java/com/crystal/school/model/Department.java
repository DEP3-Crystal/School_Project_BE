package com.crystal.school.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "name")
    private String name;
    @Column(name = "organizer_id")
    private Integer organizerId;
    @OneToOne
    private Organizer organizer;
    @OneToMany
    private List<Teacher> teachers;
    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<Session> sessions;

}
