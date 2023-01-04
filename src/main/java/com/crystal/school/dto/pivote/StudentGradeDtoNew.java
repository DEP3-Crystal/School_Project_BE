package com.crystal.school.dto.pivote;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentGradeDtoNew {
    private String sessionName;
    private String sessionDescription;
    private String studentFirstName;
    private String studentLastName;
    private Boolean isOptional;
    private String difficultyLevel;
    private Byte grade;
}
