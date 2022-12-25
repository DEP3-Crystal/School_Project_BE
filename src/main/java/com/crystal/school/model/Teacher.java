package com.crystal.school.model;

import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teachers")
@AllArgsConstructor
@DiscriminatorValue(value = "true")
//@Builder
public class Teacher extends Employee {
    // TODO figure out why there is a department_id field for teachers?
    private String credentials;
    @Transient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<TeacherRating> teacherRatings = new ArrayList<>();


    public Teacher(Employee employee, String credentials, List<TeacherRating> teacherRatings) {
        super(employee);
        this.credentials = credentials;
        this.teacherRatings = teacherRatings;
    }
}
