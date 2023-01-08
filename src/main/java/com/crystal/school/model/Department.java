package com.crystal.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "name")
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Session> sessions = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Teacher> teachers = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Student> students = new ArrayList<>();

}
