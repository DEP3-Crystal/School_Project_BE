package com.crystal.school.dto;

import com.crystal.school.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRegistrationDto {
//    private StudentRegistrationId studentRegistrationId;
    private Timestamp regDate;
//    private Room room;
    private User student;
}
