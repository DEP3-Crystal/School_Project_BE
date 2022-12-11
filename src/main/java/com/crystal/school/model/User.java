package com.crystal.school.model;

import com.crystal.school.model.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "is_employee",
        discriminatorType = DiscriminatorType.INTEGER)
@Entity
@Table(name = "person")
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
    private List<StudentRegistration> registrations;
    @OneToMany(mappedBy = "student")
    private List<StudentGrade> studentGrades;
    @OneToMany(mappedBy = "student")
    private List<SessionRating> sessionRatings;
    @OneToMany(mappedBy = "student")
    private List<TeacherRating> teacherRatings;
}
