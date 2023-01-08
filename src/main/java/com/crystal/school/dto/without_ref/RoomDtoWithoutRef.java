package com.crystal.school.dto.without_ref;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDtoWithoutRef {
    private Integer roomId;
    private Integer floor;
    private Integer doorNumber;
    private String type;
    private Integer capacity;
}
