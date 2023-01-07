package com.crystal.school.dto.without_ref;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomWithoutRef {
    private Integer roomId;
    @Min(0)
    private Integer floor;
    @Min(1)
    private Integer doorNumber;
    @Size(min = 2, max = 30)
    private String type;
    private Integer capacity;

}
