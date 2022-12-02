package com.crystal.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "session_rating")
public class Session_rating implements Serializable {
    @Id
    @Column(name = "session_id")
    private Integer session_id;
    @Id
    @Column(name = "student_id")
    private Integer student_id;
    @Column(name = "rating")
    private Integer rating;
}
