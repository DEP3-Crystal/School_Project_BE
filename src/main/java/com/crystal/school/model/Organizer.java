package com.crystal.school.model;

import javax.persistence.*;


@Entity
@Table(name = "organizer")
public class Organizer extends Worker {
    @OneToOne
    private Department department;

}
