package com.crystal.school.dto.without_ref.pivote;

import com.crystal.school.model.id.SessionRatingId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionRatingDtoWithoutRef {
    private SessionRatingId sessionRatingId;
    private Byte rating;
}
