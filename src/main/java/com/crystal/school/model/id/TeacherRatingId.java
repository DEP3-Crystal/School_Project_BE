package com.crystal.school.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRatingId implements Serializable {
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "teacher_id")
    private Integer teacherId;
}
