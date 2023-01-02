package com.crystal.school.dto.pivote;

import com.crystal.school.dto.SessionDto;
import com.crystal.school.model.id.SessionRegistrationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionRegistrationDto {

    private SessionRegistrationId sessionRegistrationId;
    private Timestamp regDate;
    private SessionDto session;
}
