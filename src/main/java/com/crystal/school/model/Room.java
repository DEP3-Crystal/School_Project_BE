package com.crystal.school.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "school_id")
    private Integer schoolId;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "door_number")
    private Integer doorNumber;
    @Column(name = "type")
    private String type;
    @ManyToOne
    private School school;
    @OneToMany
    private List<Classroom> classrooms;
}
