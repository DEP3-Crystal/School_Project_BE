package com.crystal.school.mapper;

import com.crystal.school.dto.RoomDto;
import com.crystal.school.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper Instance  = Mappers.getMapper(RoomMapper.class);

    Room toRoom(RoomDto roomDto);
    RoomDto toRoomDto(Room room);
}
