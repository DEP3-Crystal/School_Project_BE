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
    @Autowired
    private RoomRepository roomRepository;

    public RoomDto getRoomById(Integer id) {
        return RoomMapper.Instance.toRoomDto(roomRepository.findById(id).orElse(null));
    }

    public List<RoomDto> getRooms() {
        return roomRepository.findAll().stream().map(RoomMapper.Instance::toRoomDto).toList();
    }

    public void deleteRoomById(Integer id) {
        roomRepository.deleteById(id);
    }

    public void deleteRooms() {
        roomRepository.deleteAll();
    }

    public void deleteRoom(Room room) {
        roomRepository.delete(room);
    }

    public RoomDto addRoom(Room room) {
        return RoomMapper.Instance.toRoomDto(roomRepository.save(room));
    }

    public List<RoomDto> addRooms(List<Room> rooms) {
        return roomRepository.saveAll(rooms).stream().map(RoomMapper.Instance::toRoomDto).toList();
    }

    public RoomDto editRoom(Room room) {
        Room existingRoom = roomRepository.findById(room.getRoomId()).orElseThrow(ResourceNotFoundException::new);
        existingRoom.setRoomId(room.getRoomId());
        existingRoom.setDoorNumber(room.getDoorNumber());
        existingRoom.setFloor(room.getFloor());
        existingRoom.setSchool(room.getSchool());
        existingRoom.setType(room.getType());
        return RoomMapper.Instance.toRoomDto(roomRepository.save(existingRoom));
    }
}
