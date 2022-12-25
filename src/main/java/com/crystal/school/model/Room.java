package com.crystal.school.model;


import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.model.pivote.StudentRegistration;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    @ToString.Exclude
    private School school;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private List<SessionRegistration> sessionRegistrations = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();

}
