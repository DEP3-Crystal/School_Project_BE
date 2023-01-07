package com.crystal.school.service;

import com.crystal.school.dto.RoomDto;
import com.crystal.school.exception.ResourceNotFoundException;
import com.crystal.school.mapper.RoomMapper;
import com.crystal.school.model.Room;
import com.crystal.school.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private static final RoomMapper mapper = RoomMapper.Instance;
    @Autowired
    private RoomRepository roomRepository;

    public RoomDto getRoomById(Integer id) {
        return mapper.toRoomDto(roomRepository.findById(id).orElse(null));
    }

    public List<RoomDto> getRooms() {
        return roomRepository.findAll().stream().map(mapper::toRoomDto).toList();
    }

    public void deleteRoomById(Integer id) {
        roomRepository.deleteById(id);
    }

    public void deleteRooms() {
        roomRepository.deleteAll();
    }

    public void deleteRoom(RoomDto room) {
        roomRepository.deleteById(room.getRoomId());
    }

    public RoomDto addRoom(RoomDto room) {
        Room savedRoom = roomRepository.save(mapper.toRoom(room));
        return mapper.toRoomDto(savedRoom);
    }

    public List<RoomDto> addRooms(List<RoomDto> roomsDto) {
        List<Room> rooms = roomsDto.stream().map(mapper::toRoom).toList();
        return roomRepository.saveAll(rooms).stream()
                .map(mapper::toRoomDto)
                .toList();
    }

    public RoomDto editRoom(RoomDto roomDto) {
        if (!roomRepository.existsById(roomDto.getRoomId()))
            throw new ResourceNotFoundException("Room with id " + roomDto.getRoomId() + "was not found");

        return mapper.toRoomDto(roomRepository.save(mapper.toRoom(roomDto)));
    }
}
