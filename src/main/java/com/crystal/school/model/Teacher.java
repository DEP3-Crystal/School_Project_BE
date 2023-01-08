package com.crystal.school.model;

import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teachers")
@AllArgsConstructor
@DiscriminatorValue(value = "TEACHER")
@SuperBuilder(builderMethodName = "createTeacherBuilder")
public class Teacher extends Employee {
    @ManyToOne()
    @JoinColumn(name = "department_id")
    protected Department department;

    @Column(name = "credentials")
    @Size(max = 255)
    @NotNull
    private String credentials;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private List<TeacherRating> teacherRatings;

    public Teacher(@NotNull Employee employee, @NotNull String credentials, List<TeacherRating> teacherRatings) {
        super(employee);
        this.credentials = credentials;
        this.teacherRatings = teacherRatings;
    }


}