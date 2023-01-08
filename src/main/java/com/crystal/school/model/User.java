package com.crystal.school.model;

import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;


@Data
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "role",
//        discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "STUDENT")
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "createUserBuilder")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "first_name")
    @Size(max = 255)
    @NotNull
    protected String firstName;

    @Column(name = "last_name")
    @Size(max = 255)
    @NotNull
    protected String lastName;

    @Column(name = "email", unique = true)
    @Size(max = 255)
    @NotNull
    protected String email;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @NotNull
    protected Gender gender;

    @Column(name = "biography")
    protected String biography;


    @Column(name = "password")
    @NotNull
    protected String password;

    @Column(name = "salt")
    @NotNull
    protected String salt;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    protected Role role;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    protected Image profilePicture;

    protected Timestamp birthDate;

    public User(User user) {
        id = user.id;
        firstName = user.firstName;
        lastName = user.lastName;
        email = user.email;
        gender = user.gender;
        biography = user.biography;
        password = user.password;
        salt = user.salt;
        profilePicture = user.profilePicture;
        role = user.role;
        birthDate = user.birthDate;
    }
}
