package com.crystal.school.dto_old.pivote;

import com.crystal.school.dto_old.SessionDto;
import com.crystal.school.model.id.StudentRegistrationId;
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
    private StudentRegistrationId studentRegistrationId;
    private Timestamp regDate;
    //    private UserDto student;
    private SessionDto session;

}
