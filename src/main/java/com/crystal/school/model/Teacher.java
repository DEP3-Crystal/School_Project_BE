package com.crystal.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher extends Employee{
    private String credentials;
    @OneToMany(mappedBy = "teacher")
    private List<TeacherRating> teacherRatings;
}
