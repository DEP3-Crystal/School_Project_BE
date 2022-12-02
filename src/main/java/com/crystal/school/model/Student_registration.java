package com.crystal.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "student_registration")
public class Student_registration implements Serializable{
    @Id
    @Column(name = "student_id")
    private Integer student_id;
    @Id
    @Column(name = "classroom_id")
    private Integer classroom_id;
    @Column(name = "datetime")
    private Timestamp datetime;

}
