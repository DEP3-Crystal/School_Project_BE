package com.crystal.school.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class StudentGradeId implements Serializable {
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "session_id")
    private Integer sessionId;
}
