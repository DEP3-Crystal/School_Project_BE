package com.crystal.school.mapper;

import com.crystal.school.dto.SessionRatingDto;
import com.crystal.school.dto.TeacherDto;
import com.crystal.school.model.Teacher;
import com.crystal.school.model.pivote.SessionRating;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionRatingMapper{
    SessionRatingMapper Instance  = Mappers.getMapper(SessionRatingMapper.class);

    SessionRating toSessionRating(SessionRatingDto sessionRatingDto);
    SessionRatingDto toSessionRatingDto(SessionRating sessionRating);
}
