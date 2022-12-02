package com.crystal.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "session_registration")
public class Session_registration implements Serializable {
    @Id
    @Column(name = "session_id")
    private Integer session_id;
    @Id
    @Column(name = "classroom_id")
    private Integer classroom_id;
    @Column(name = "start_time")
    private Timestamp start_time;
    @Column(name = "end_time")
    private Timestamp end_time;
}
