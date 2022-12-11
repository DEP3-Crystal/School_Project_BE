package com.crystal.school.model;


import com.crystal.school.model.enums.Role;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "1")
@NoArgsConstructor
public class Employee extends User {

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "role")
    private String _role;
    @Transient
    private Role role;
    public Role getRole() {
        if (role == null)
            role = Role.getEnum(_role);
        return role;
    }

    public Employee(Integer userId, String firstName, String lastName, String email, String _gender, String biography,
                    String password, String salt, Department department,
                    List<StudentRegistration> registrations, List<StudentGrade> studentGrades, List<SessionRating> sessionRatings, List<TeacherRating> teacherRatings,
                    String phoneNumber, String title, String _role) {
        super(userId, firstName, lastName, email, _gender, null, biography, password, salt, department, registrations, studentGrades, sessionRatings, teacherRatings);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this._role = _role;
    }

    public Employee(User user, String phoneNumber, String title, String _role) {
        super(user);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this._role = _role;
    }

    public Employee(User user, Employee employee) {
        super(user);
        phoneNumber = employee.phoneNumber;
        title = employee.title;
        _role = employee._role;
    }

    public Employee(Employee employee) {
        phoneNumber = employee.phoneNumber;
        title = employee.title;
        _role = employee._role;
    }



}
