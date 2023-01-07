package com.crystal.school.mapper;

import com.crystal.school.dto_old.RoomDto;
import com.crystal.school.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomMapper Instance = Mappers.getMapper(RoomMapper.class);

    Room toRoom(RoomDto roomDto);

    RoomDto toRoomDto(Room room);
}
