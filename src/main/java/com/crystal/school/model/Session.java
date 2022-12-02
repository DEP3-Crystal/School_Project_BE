package com.crystal.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @Column(name = "session_id")
    private Integer session_id;
    @Column(name = "department_id")
    private Integer department_id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "difficulty_level")
    private String difficulty_level;
    @Column(name = "keywords")
    private String keywords;
}
