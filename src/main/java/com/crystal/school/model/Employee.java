package com.crystal.school.model;


import com.crystal.school.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "true")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;


    public Employee(User user, String phoneNumber, String title, Role role) {
        super(user);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.role = role;
    }


    public Employee(Employee employee) {
        super(employee);
        phoneNumber = employee.phoneNumber;
        title = employee.title;
        role = employee.role;
    }

}
