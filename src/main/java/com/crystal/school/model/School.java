package com.crystal.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school")
public class School{
    @Id
    @Column(name = "building_id")
    private Integer buildingId;
    @Column(name = "location")
    private String location;
    @Column(name = "name")
    private String name;
    @OneToMany
    private List<Room> rooms;

}
