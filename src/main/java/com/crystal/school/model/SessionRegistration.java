package com.crystal.school.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "session_registration")
public class SessionRegistration implements Serializable {
    @Id
    @Column(name = "session_id")
    private Integer sessionId;
    @Id
    @Column(name = "classroom_id")
    private Integer classroomId;
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;
    @ManyToOne
    private Classroom classroom;
    @ManyToOne
    private Session session;
}
