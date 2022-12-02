package com.crystal.school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="status",
//        discriminatorType = DiscriminatorType.INTEGER)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer user_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "biography")
    private String biography;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private Status status;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Worker> workers;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Student> students;

}
