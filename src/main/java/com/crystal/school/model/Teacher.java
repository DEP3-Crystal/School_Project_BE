package com.crystal.school.model;

import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teachers")
@AllArgsConstructor
@DiscriminatorValue(value = "Teacher")
@Builder
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
}