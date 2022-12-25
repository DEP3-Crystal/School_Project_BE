package com.crystal.school.dto;

import com.crystal.school.model.id.SessionRatingId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionRatingDto {
    private SessionRatingId sessionRatingId;
    private Byte rating;
    private UserDto student;
//    private Session session;

}
