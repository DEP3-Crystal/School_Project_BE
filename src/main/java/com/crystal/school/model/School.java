package com.crystal.school.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schools")
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
