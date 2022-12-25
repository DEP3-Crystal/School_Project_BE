package com.crystal.school.model.pivote;


import com.crystal.school.model.Room;
import com.crystal.school.model.User;
import com.crystal.school.model.id.StudentRegistrationId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_registrations")
public class StudentRegistration {
    @EmbeddedId
    private StudentRegistrationId studentRegistrationId;

    @Column(name = "reg_date")
    private Timestamp regDate;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private User student;
}
