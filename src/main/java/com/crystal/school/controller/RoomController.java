package com.crystal.school.controller;

import com.crystal.school.model.Room;
import com.crystal.school.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/room/{id}")
    public Room getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("/room")
    public Room addRoom(Room room) {
        return roomService.addRoom(room);
    }

    @PostMapping("/rooms")
    public List<Room> addRooms(List<Room> rooms) {
        return roomService.addRooms(rooms);
    }

    @PutMapping("/room")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.editRoom(room);
    }

    @DeleteMapping("/room{id}")
    public void deleteRoomById(@PathVariable Integer id) {
        roomService.deleteRoomById(id);
    }

    @DeleteMapping("/rooms")
    public void deleteAllRooms() {
        roomService.deleteRooms();
    }

    @DeleteMapping("/room")
    public void deleteRoom(@RequestBody Room room) {
        roomService.deleteRoom(room);
    }


}
