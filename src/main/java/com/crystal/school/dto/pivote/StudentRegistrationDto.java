package com.crystal.school.dto.pivote;


import com.crystal.school.dto.without_ref.SessionDtoWithoutRef;
import com.crystal.school.dto.without_ref.UserInfoDtoWithoutRef;
import com.crystal.school.model.id.StudentRegistrationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistrationDto {
    private StudentRegistrationId studentRegistrationId;

    private Timestamp regDate;
    private UserInfoDtoWithoutRef student;

    private SessionDtoWithoutRef session;
}
