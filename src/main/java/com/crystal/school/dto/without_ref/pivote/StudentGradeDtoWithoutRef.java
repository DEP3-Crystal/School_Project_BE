package com.crystal.school.dto.without_ref.pivote;


import com.crystal.school.model.id.StudentGradeId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGradeDtoWithoutRef {
    private StudentGradeId studentGradeId;
    private Byte grade;

}
