package com.crystal.school.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "location")
    private String location;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "school")
    private List<Room> rooms;

}
