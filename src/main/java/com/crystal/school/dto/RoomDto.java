package com.crystal.school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDto {

    private Integer roomId;
    private Integer floor;
    private Integer doorNumber;
    private String type;
    private Integer capacity;
    private List<SessionRegistrationDto> sessionRegistrations;
    private List<StudentRegistrationDto> studentRegistrations;
}
