package com.crystal.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher_rating")
public class TeacherRating implements Serializable {
    @Id
    @Column(name = "student_id")
    private Integer studentId;
    @Id
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "rating")
    private Integer rating;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Teacher teacher;
}
