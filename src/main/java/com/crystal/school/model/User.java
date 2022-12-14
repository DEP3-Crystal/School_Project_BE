package com.crystal.school.model;

import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "is_employee",
        discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "false")
@Entity
@Table(name = "users")
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "biography")
    private String biography;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
//    @Column(name = "is_employee")
//    private Integer isEmployee;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<StudentRegistration> registrations;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<StudentGrade> studentGrades;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<SessionRating> sessionRatings;
    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<TeacherRating> teacherRatings;


    public User(User user) {
        userId = user.userId;
        firstName = user.firstName;
        lastName = user.lastName;
        email = user.email;
        gender = user.gender;
        biography = user.biography;
        password = user.password;
        salt = user.salt;
        department = user.department;
        registrations = user.registrations;
        studentGrades = user.studentGrades;
        sessionRatings = user.sessionRatings;
        teacherRatings =user.teacherRatings;

    }

}
