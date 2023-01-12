package com.crystal.school.dto.without_ref.pivote;

import com.crystal.school.model.id.StudentRegistrationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(builderMethodName = "createStudentBuilder")
public class StudentRegistrationDtoWithoutRef {
    private StudentRegistrationId studentRegistrationId;
    private Timestamp regDate;

}
