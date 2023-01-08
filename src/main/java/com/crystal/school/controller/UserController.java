package com.crystal.school.controller;

import com.crystal.school.dto.UserInfoDto;
import com.crystal.school.dto.UserLogin;
import com.crystal.school.dto.registration.UserRegistrationDto;
import com.crystal.school.exception.ResourceNotFoundException;
import com.crystal.school.service.LoginService;
import com.crystal.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/users")
    public List<UserInfoDto> getUserList() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserInfoDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }


    @PostMapping("/users/add")
    public UserInfoDto addUser(@RequestBody UserRegistrationDto user) {
        return userService.createUser(user);
    }

    @PutMapping("/user/updateInfo")
    public UserInfoDto updateUser(@RequestBody UserInfoDto user) {
        return userService.updateUser(user);
    }

    @PutMapping("/user/updatePassword")
    public UserInfoDto updatePassword(@RequestBody UserLogin user) {
        return userService.updatePassword(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PostMapping("users/login")
    public ResponseEntity<UserInfoDto> loginUser(@RequestBody UserLogin userData) {
        try {
            UserInfoDto user = userService.loginUser(userData);
            return ResponseEntity.ok(user);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
