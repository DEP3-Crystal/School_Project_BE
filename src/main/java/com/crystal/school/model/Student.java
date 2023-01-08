package com.crystal.school.model;

import com.crystal.school.model.pivote.SessionRating;
import com.crystal.school.model.pivote.StudentGrade;
import com.crystal.school.model.pivote.StudentRegistration;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Data
@DiscriminatorValue(value = "STUDENT")
@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(builderMethodName = "createStudentBuilder")
public class Student extends User {

    private Integer grade;

    @OneToMany(mappedBy = "student")
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<StudentGrade> studentGrades = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<SessionRating> sessionRatings = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<TeacherRating> teacherRatings = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name = "department_id")
    protected Department department;

}
