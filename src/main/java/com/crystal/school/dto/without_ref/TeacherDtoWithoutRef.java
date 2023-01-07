package com.crystal.school.dto.without_ref;

import com.crystal.school.model.Employee;
import com.crystal.school.model.pivote.TeacherRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDtoWithoutRef extends EmployeeWithoutRef {

    @NonNull
    private String credentials;


}