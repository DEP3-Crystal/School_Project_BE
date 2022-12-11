package com.crystal.school.model;

import com.crystal.school.model.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "is_employee",
        discriminatorType = DiscriminatorType.INTEGER)
@Entity
@Table(name = "person")
@NoArgsConstructor
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
    private String _gender;
    @Transient
    private Gender gender;
    public Gender getGender(){
        if(gender == null)
            gender = Gender.valueOf(_gender);
        return  gender;
    }
    @Column(name = "biography")
    private String biography;
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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
        _gender = user._gender;
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
