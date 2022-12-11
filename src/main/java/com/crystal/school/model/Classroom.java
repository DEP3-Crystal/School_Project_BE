package com.crystal.school.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @Column(name = "classroom_id")
    private Integer classroomId;

    @Column(name = "capacity")
    private Integer capacity;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(mappedBy = "classroom")
    private List<SessionRegistration> registration;
    @OneToMany(mappedBy = "classroom")
    private List<StudentRegistration> studentRegistrations;

}
