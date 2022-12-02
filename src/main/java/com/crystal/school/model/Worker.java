package com.crystal.school.model;

import javax.persistence.*;

@Entity
@Table(name = "worker")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("W")
public class Worker extends User {

    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "title")
    private String title;
    @Column(name = "is_teacher")
    private boolean is_teacher;
    @Column(name = "is_organizer")
    private boolean is_organizer;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
