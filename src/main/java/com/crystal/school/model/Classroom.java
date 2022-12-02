package com.crystal.school.model;

import javax.persistence.*;

@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @Column(name = "classroom_id")
    private Integer classroom_id;
    @Column(name = "room_id")
    private Integer room_id;
    @Column(name = "capacity")
    private Integer capacity;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
