package com.crystal.school.dto;


import com.crystal.school.dto.without_ref.SchoolDtoWithoutRef;
import com.crystal.school.dto.without_ref.SessionDtoWithoutRef;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDto {
    private Integer roomId;
    @Min(0)
    private Integer floor;
    @Min(1)
    private Integer doorNumber;
    @Size(min = 2, max = 30)
    private String type;
    private Integer capacity;
    private SchoolDtoWithoutRef school;
    private List<SessionDtoWithoutRef> sessionRegistrations = new ArrayList<>();

}
