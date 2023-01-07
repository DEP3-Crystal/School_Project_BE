package com.crystal.school.mapper;

import com.crystal.school.dto_old.SchoolDto;
import com.crystal.school.model.School;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolMapper Instance = Mappers.getMapper(SchoolMapper.class);

    School toSchool(SchoolDto schoolDto);

    SchoolDto toSchoolDto(School school);
}
