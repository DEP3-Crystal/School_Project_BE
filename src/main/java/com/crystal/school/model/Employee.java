package com.crystal.school.model;


import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "true")
@NoArgsConstructor
public class Employee extends User {

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Employee(Integer userId, String firstName, String lastName, String email, Gender gender, String biography,
                    String password, String salt, Department department,
                    List<StudentRegistration> registrations, List<StudentGrade> studentGrades, List<SessionRating> sessionRatings, List<TeacherRating> teacherRatings,
                    String phoneNumber, String title, Role role) {
        super(userId, firstName, lastName, email, gender, biography, password, salt, department, registrations, studentGrades, sessionRatings, teacherRatings);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.role = role;
    }

    public Employee(User user, String phoneNumber, String title, Role role) {
        super(user);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.role = role;
    }

    public Employee(User user, Employee employee) {
        super(user);
        phoneNumber = employee.phoneNumber;
        title = employee.title;
        role = employee.role;
    }

    public Employee(Employee employee) {
        phoneNumber = employee.phoneNumber;
        title = employee.title;
        role = employee.role;
    }

}
