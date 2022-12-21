package com.crystal.school.mapper;

import com.crystal.school.dto.SessionDto;
import com.crystal.school.model.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SessionMapper {
    SessionMapper Instance = Mappers.getMapper(SessionMapper.class);

    Session toSession(SessionDto sessionDto);

    SessionDto toSessionDto(Session session);
}
