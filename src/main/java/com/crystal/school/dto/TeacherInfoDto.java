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
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInfoDto extends EmployeeInfoDto {

    @Size(max = 255)
    @NonNull
    private String credentials;
    private List<TeacherRatingDtoWithoutRef> teacherRatings = new ArrayList<>();

    @Builder
    public TeacherInfoDto(Integer id, @NonNull String firstName, @NonNull String lastName, @NonNull String email, @NonNull Gender gender, String biography, Role role, Image profilePicture, DepartmentDtoWithoutRef department, List<StudentRegistrationDtoWithoutRef> studentRegistrations, List<StudentGradeDtoWithoutRef> studentGrades, List<SessionRatingDtoWithoutRef> sessionRatings, List<TeacherRatingDtoWithoutRef> teacherRatings, @NonNull String phoneNumber, @NonNull String title, @NonNull Timestamp hireDate, BigDecimal salary, @NonNull String credentials, List<TeacherRatingDtoWithoutRef> teacherRatings1) {
        super(id, firstName, lastName, email, gender, biography, role, profilePicture, department, studentRegistrations, studentGrades, sessionRatings, teacherRatings, phoneNumber, title, hireDate, salary);
        this.credentials = credentials;
        this.teacherRatings = teacherRatings1;
    }
}