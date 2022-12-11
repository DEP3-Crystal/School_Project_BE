package com.crystal.school.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}
