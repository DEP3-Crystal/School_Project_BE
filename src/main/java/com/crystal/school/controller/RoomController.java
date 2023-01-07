package com.crystal.school.controller;

import com.crystal.school.dto.RoomDto;
import com.crystal.school.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<RoomDto> getAllRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/room/{id}")
    public RoomDto getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("/room")
    public RoomDto addRoom(RoomDto room) {
        return roomService.addRoom(room);
    }

    @PostMapping("/rooms")
    public List<RoomDto> addRooms(List<RoomDto> rooms) {
        return roomService.addRooms(rooms);
    }

    @PutMapping("/room")
    public RoomDto updateRoom(@RequestBody RoomDto room) {
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
    public void deleteRoom(@RequestBody RoomDto room) {
        roomService.deleteRoom(room);
    }


}
