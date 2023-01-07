package com.crystal.school.dto_old.pivote;

import com.crystal.school.dto_old.UserInfoDto;
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
    private UserInfoDto student;
//    private Session session;

}
