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

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teachers")
@AllArgsConstructor
@DiscriminatorValue(value = "TEACHER")
public class Teacher extends Employee {

    @Column(name = "credentials")
    @Size(max = 255)
    @NonNull
    private String credentials;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<TeacherRating> teacherRatings = new ArrayList<>();

    public Teacher(@NonNull Employee employee, @NonNull String credentials, List<TeacherRating> teacherRatings) {
        super(employee);
        this.credentials = credentials;
        this.teacherRatings = teacherRatings;
    }

    @Builder
    public Teacher(Integer id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull Gender gender, String biography, @NonNull String password, @NonNull String salt, Role role, Image profilePicture, Department department, List<StudentRegistration> studentRegistrations, List<StudentGrade> studentGrades, List<SessionRating> sessionRatings, List<TeacherRating> teacherRatings, @NonNull String phoneNumber, @NonNull String title, @NonNull Timestamp hireDate, BigDecimal salary, @NonNull String credentials, List<TeacherRating> teacherRatings1) {
        super(id, firstName, lastName, email, gender, biography, password, salt, role, profilePicture, department, studentRegistrations, studentGrades, sessionRatings, teacherRatings, phoneNumber, title, hireDate, salary);
        this.credentials = credentials;
        this.teacherRatings = teacherRatings1;
    }
}