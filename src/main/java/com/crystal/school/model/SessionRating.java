package com.crystal.school.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "session_rating")
public class SessionRating implements Serializable {
    @Id
    @Column(name = "session_id")
    private Integer sessionId;
    @Id
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "rating")
    private Integer rating;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Session session;
}
