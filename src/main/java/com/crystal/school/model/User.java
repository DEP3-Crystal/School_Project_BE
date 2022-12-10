package com.crystal.school.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="status",
//        discriminatorType = DiscriminatorType.INTEGER)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "biography")
    private String biography;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name = "status")
    private Status status;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Worker> workers;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Student> students;

}
