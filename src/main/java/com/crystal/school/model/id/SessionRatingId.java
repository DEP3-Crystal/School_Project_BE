package com.crystal.school.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SessionRatingId implements Serializable {
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "student_id")
    private Integer studentId;
}
