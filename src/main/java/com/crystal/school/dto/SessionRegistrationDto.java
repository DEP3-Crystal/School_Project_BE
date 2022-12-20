package com.crystal.school.dto;

import com.crystal.school.model.Room;
import com.crystal.school.model.Session;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionRegistrationDto {

//    private SessionRegistrationId sessionRegistrationId;
//    private Timestamp regDate;
    private Session session;
    private Room room;
}
