package com.crystal.school.dto;

import com.crystal.school.dto.without_ref.SchoolDtoWithoutRef;
import com.crystal.school.dto.without_ref.SessionDtoWithoutRef;
import com.crystal.school.dto.without_ref.TeacherInfoDtoWithoutRef;
import com.crystal.school.dto.without_ref.UserInfoDtoWithoutRef;
import com.crystal.school.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Integer departmentId;
    private String name;
    private Employee employee;
    private SchoolDtoWithoutRef school;
    private List<SessionDtoWithoutRef> sessions = new ArrayList<>();
    private List<TeacherInfoDtoWithoutRef> teachers = new ArrayList<>();
    private List<UserInfoDtoWithoutRef> students = new ArrayList<>();

}
