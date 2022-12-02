package com.crystal.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "school")
public class School{
    @Id
    @Column(name = "building_id")
    private Integer building_id;
    @Column(name = "location")
    private String location;
    @Column(name = "name")
    private String name;

}
