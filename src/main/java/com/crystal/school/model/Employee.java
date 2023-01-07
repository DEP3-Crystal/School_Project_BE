package com.crystal.school.model;

import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "EMPLOYEE")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {

    @Column(name = "phone_number")
    @Size(max = 255)
    @NonNull
    private String phoneNumber;

    @Column(name = "title")
    @Size(max = 255)
    @NonNull
    private String title;

    @Column(name = "hire_date")
    @NonNull
    private Timestamp hireDate;
    private BigDecimal salary;

    public Employee(User user, String phoneNumber, String title, Timestamp hireDate, BigDecimal salary) {
        super(user);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.hireDate = hireDate;
        this.salary = salary;
    }


    public Employee(Employee employee) {
        super(employee);
        phoneNumber = employee.phoneNumber;
        title = employee.title;
        salary = employee.salary;
        hireDate = employee.hireDate;
    }

    public Employee(Integer id, @Size(max = 255) @NonNull String firstName, @Size(max = 255) @NonNull String lastName, @Size(max = 255) @NonNull String email, @NonNull Gender gender, String biography, @NonNull String password, @NonNull String salt, Role role, Image profilePicture, Department department, List<StudentRegistration> studentRegistrations, List<StudentGrade> studentGrades, List<SessionRating> sessionRatings, List<TeacherRating> teacherRatings, @NonNull String phoneNumber, @NonNull String title, @NonNull Timestamp hireDate, BigDecimal salary) {
        super(id, firstName, lastName, email, gender, biography, password, salt, role, profilePicture, department, studentRegistrations, studentGrades, sessionRatings, teacherRatings);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.hireDate = hireDate;
        this.salary = salary;
    }
}
