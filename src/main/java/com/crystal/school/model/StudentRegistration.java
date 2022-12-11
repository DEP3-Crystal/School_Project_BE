package com.crystal.school.model;


import com.crystal.school.model.id.StudentRegistrationId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "student_registration")
public class StudentRegistration {
    @EmbeddedId
    private StudentRegistrationId studentRegistrationId;
    @Column(name = "datetime")
    private Timestamp datetime;
    @Column(name = "reg_date")
    private Timestamp regDate;

    @ManyToOne
    @JoinColumn(name = "classroom_id", insertable = false, updatable = false)
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User student;
}
