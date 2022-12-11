package com.crystal.school.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "door_number")
    private Integer doorNumber;
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
