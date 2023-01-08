package com.crystal.school.dto.pivote;


import com.crystal.school.dto.without_ref.SessionDtoWithoutRef;
import com.crystal.school.dto.without_ref.StudentInfoDtoWithoutRef;
import com.crystal.school.model.id.SessionRatingId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionRatingDto {
    private SessionRatingId sessionRatingId;
    private Byte rating;
    private StudentInfoDtoWithoutRef student;
    private SessionDtoWithoutRef session;
}
