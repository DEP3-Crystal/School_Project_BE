package com.crystal.school.mapper;

import com.crystal.school.dto.pivote.TeacherRatingDto;
import com.crystal.school.model.pivote.TeacherRating;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherRatingMapper {
    TeacherRatingMapper Instance = Mappers.getMapper(TeacherRatingMapper.class);

    TeacherRating toTeacherRating(TeacherRatingDto teacherRatingDto);

    TeacherRatingDto toTeacherRatingDto(TeacherRating teacherRating);
}
