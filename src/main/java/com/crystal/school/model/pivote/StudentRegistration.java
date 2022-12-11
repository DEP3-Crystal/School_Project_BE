package com.crystal.school.model.pivote;


import com.crystal.school.model.Room;
import com.crystal.school.model.User;
import com.crystal.school.model.id.StudentRegistrationId;
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
@Table(name = "student_registration")
public class StudentRegistration {
    @EmbeddedId
    private StudentRegistrationId studentRegistrationId;

    @Column(name = "reg_date")
    private Timestamp regDate;

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User student;
}
