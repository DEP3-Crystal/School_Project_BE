package com.crystal.school.model;


import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.model.pivote.StudentRegistration;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "rooms")
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
    @Column(name = "capacity")
    private Integer capacity;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @OneToMany(mappedBy = "room")
    private List<SessionRegistration> sessionRegistrations;
    @OneToMany(mappedBy = "room")
    private List<StudentRegistration> studentRegistrations;
}
