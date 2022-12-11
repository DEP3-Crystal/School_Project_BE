package com.crystal.school.model;


import com.crystal.school.model.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorValue(value = "1")
public class Employee extends User {

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "role")
    private String _role;
    @Transient
    private Role role;
    public Role getRole(){
        if(role == null)
            role = Role.getEnum(_role);
        return role;
    }
}
