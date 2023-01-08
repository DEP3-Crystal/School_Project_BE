package com.crystal.school.dto.without_ref;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SessionDtoWithoutRef {
    private Integer id;
    private String title;
    private String description;
    private Timestamp start;
    private Timestamp end;
    @JsonProperty("isOptional")
    private Boolean isOptional;
    private Timestamp regDate;
    private String difficultyLevel;
    private String keywords;

}
