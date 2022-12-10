package com.crystal.school.model;

import lombok.Data;

@Data
public class UserSignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String biography;
    private Status status;
}
