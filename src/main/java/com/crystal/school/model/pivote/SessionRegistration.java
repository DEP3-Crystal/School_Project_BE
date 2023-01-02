package com.crystal.school.model.pivote;


import com.crystal.school.model.Room;
import com.crystal.school.model.Session;
import com.crystal.school.model.id.SessionRegistrationId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session_registrations")
public class SessionRegistration {
    @EmbeddedId
    @JsonIgnore
    private SessionRegistrationId sessionRegistrationId = new SessionRegistrationId();
    @Column(name = "reg_date")
    private Timestamp regDate;

    @MapsId("sessionId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Session session;
    @MapsId("room_id")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}

