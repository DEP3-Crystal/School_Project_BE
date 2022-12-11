package com.crystal.school.service;

import com.crystal.school.model.Room;
import com.crystal.school.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room getRoomById(Integer id) {
        return roomRepository.findById(id).orElse(null);
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
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

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> addRooms(List<Room> rooms) {
        return roomRepository.saveAll(rooms);
    }

    public Room editRoom(Room room) {
        Room existingRoom = roomRepository.findById(room.getRoomId()).orElse(null);
        // TODO fix null pointer exception warning
        existingRoom.setRoomId(room.getRoomId());
        existingRoom.setDoorNumber(room.getDoorNumber());
        existingRoom.setFloor(room.getFloor());
        existingRoom.setSchool(room.getSchool());
        existingRoom.setType(room.getType());
        return roomRepository.save(existingRoom);
    }
}
