package com.crystal.school.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StudentRegistrationId implements Serializable {
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "classroom_id")
    private Integer classroomId;

}
