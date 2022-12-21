package com.crystal.school.mapper;

import com.crystal.school.dto.SessionRegistrationDto;
import com.crystal.school.model.pivote.SessionRegistration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SessionRegistrationMapper {
    SessionRegistrationMapper Instance = Mappers.getMapper(SessionRegistrationMapper.class);

    SessionRegistration toSessionRegistration(SessionRegistrationDto sessionRegistrationDto);

    SessionRegistrationDto toSessionRegistrationDto(SessionRegistration sessionRegistration);
}
