package com.crystal.school.model;

import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "role",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "STUDENT")
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @Size(max = 255)
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 255)
    @NonNull
    private String lastName;

    @Column(name = "email", unique = true)
    @Size(max = 255)
    @NonNull
    private String email;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @NonNull
    private Gender gender;

    @Column(name = "biography")
    private String biography;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "salt")
    @NonNull
    private String salt;
    @Transient
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @ToString.Exclude
    private List<StudentGrade> studentGrades = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @ToString.Exclude
    private List<SessionRating> sessionRatings = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @ToString.Exclude
    private List<TeacherRating> teacherRatings = new ArrayList<>();

    public User(User user) {
        id = user.id;
        firstName = user.firstName;
        lastName = user.lastName;
        email = user.email;
        gender = user.gender;
        biography = user.biography;
        password = user.password;
        salt = user.salt;
        department = user.department;
        studentRegistrations = user.studentRegistrations;
        studentGrades = user.studentGrades;
        sessionRatings = user.sessionRatings;
        teacherRatings = user.teacherRatings;
    }
}
