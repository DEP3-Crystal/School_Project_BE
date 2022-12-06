package com.crystal.school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @Column(name = "classroom_id")
    private Integer classroomId;
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "capacity")
    private Integer capacity;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Room room;
    @OneToMany
    private List<SessionRegistration> sessionRegistrations;
    @OneToMany
    private List<StudentRegistration> studentRegistrations;
}
