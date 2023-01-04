package com.crystal.school.model;


import com.crystal.school.model.pivote.SessionRegistration;
import com.crystal.school.model.pivote.StudentRegistration;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
@Builder
public class Room {
    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer roomId;
    @Min(0)
    @Column(name = "floor")
    private Integer floor;
    @Min(1)
    @Column(name = "door_number")
    private Integer doorNumber;
    @Size(min = 2, max = 30)
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


}
