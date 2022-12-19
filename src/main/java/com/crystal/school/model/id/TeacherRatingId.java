package com.crystal.school.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TeacherRatingId implements Serializable {
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "teacher_id")
    private Integer teacherId;
}
