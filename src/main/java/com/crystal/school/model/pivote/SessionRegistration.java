package com.crystal.school.model.pivote;


import com.crystal.school.model.Room;
import com.crystal.school.model.Session;
import com.crystal.school.model.id.SessionRegistrationId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session_registrations")
public class SessionRegistration {
    @EmbeddedId
    private SessionRegistrationId sessionRegistrationId;
    @Column(name = "reg_date")
    private Timestamp regDate;

    @ManyToOne
    @JoinColumn(name = "session_id", insertable = false, updatable = false)
    private Session session;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;
}
