package com.crystal.school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id")
    private Integer department_id;
    @Column(name = "name")
    private String name;
    @Column(name = "organizer_id")
    private Integer organizer_id;
    @OneToMany
    @JoinColumn(name = "department_id")
    private List<Teacher> teachers;

}
