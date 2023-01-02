package com.crystal.school.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Timestamp;


@Data
@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "Employee")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {

    @Column(name = "phone_number")
    @Size(max = 255)
    @NonNull
    private String phoneNumber;

    @Column(name = "title")
    @Size(max = 255)
    @NonNull
    private String title;

//    @Column(name = "role")
//    @Enumerated(EnumType.STRING)
//    @NonNull
//    private Role role;

    @Column(name = "hire_date")
    @NonNull
    private Timestamp hireDate;
    private BigDecimal salary;

    public Employee(User user, String phoneNumber, String title, Timestamp hireDate, BigDecimal salary) {
        super(user);
        this.phoneNumber = phoneNumber;
        this.title = title;
//        this.role = role;
        this.hireDate = hireDate;
        this.salary = salary;
    }


    public Employee(Employee employee) {
        super(employee);
        phoneNumber = employee.phoneNumber;
        title = employee.title;
        salary = employee.salary;
        hireDate = employee.hireDate;
    }

}
