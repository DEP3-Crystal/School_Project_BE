package com.crystal.school.dto.without_ref.pivote;

import com.crystal.school.model.id.TeacherRatingId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherRatingDtoWithoutRef {
    private TeacherRatingId teacherRatingId;
    private Byte rating;
}
