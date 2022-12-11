package com.crystal.school.model;

import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher extends Employee {
    private String credentials;
    @OneToMany(mappedBy = "teacher")
    private List<TeacherRating> teacherRatings;

    public Teacher(User user, Employee employee, String credentials, List<TeacherRating> teacherRatings) {
        super(user, employee);
        this.credentials = credentials;
        this.teacherRatings = teacherRatings;
    }

    public Teacher(Employee employee, String credentials, List<TeacherRating> teacherRatings) {
        super(employee);
        this.credentials = credentials;
        this.teacherRatings = teacherRatings;
    }
}
