package com.crystal.school.dto;

import com.crystal.school.dto.without_ref.DepartmentDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.SessionRatingDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentGradeDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.StudentRegistrationDtoWithoutRef;
import com.crystal.school.dto.without_ref.pivote.TeacherRatingDtoWithoutRef;
import com.crystal.school.model.Image;
import com.crystal.school.model.enums.Gender;
import com.crystal.school.model.enums.Role;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfoDto extends UserInfoDto {

    @Size(max = 255)
    @NonNull
    private String phoneNumber;

    @Size(max = 255)
    @NonNull
    private String title;

    @NonNull
    private Timestamp hireDate;
    private BigDecimal salary;
    public EmployeeInfoDto(Integer id, @Size(max = 255) @NonNull String firstName, @Size(max = 255) @NonNull String lastName, @Size(max = 255) @NonNull String email, @NonNull Gender gender, String biography, Role role, Image profilePicture, DepartmentDtoWithoutRef department, List<StudentRegistrationDtoWithoutRef> studentRegistrations, List<StudentGradeDtoWithoutRef> studentGrades, List<SessionRatingDtoWithoutRef> sessionRatings, List<TeacherRatingDtoWithoutRef> teacherRatings, @NonNull String phoneNumber, @NonNull String title, @NonNull Timestamp hireDate, BigDecimal salary) {
        super(id, firstName, lastName, email, gender, biography, role, profilePicture, department, studentRegistrations, studentGrades, sessionRatings, teacherRatings);
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.hireDate = hireDate;
        this.salary = salary;
    }
}
