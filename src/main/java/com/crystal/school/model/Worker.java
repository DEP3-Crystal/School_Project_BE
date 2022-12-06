package com.crystal.school.model;

import javax.persistence.*;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name = "worker")
@Inheritance(strategy=SINGLE_TABLE)
public class Worker extends User {

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "is_teacher")
    private boolean isTeacher;
    @Column(name = "is_organizer")
    private boolean isOrganizer;
}
