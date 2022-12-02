package com.crystal.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private Integer room_id;
    @Column(name = "school_id")
    private Integer school_id;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "door_number")
    private Integer door_number;
    @Column(name = "type")
    private String type;
}
