package com.crystal.school.controller;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.dto.UserDto;
import com.crystal.school.model.User;
import com.crystal.school.model.UserLogin;
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
    private final FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/users")
    public List<UserDto> getUserList() {
        //return fakerDataAccess.generateUsers(500);
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

//    @GetMapping("/user/{email}")
//    public UserDto getUserByEmail(@PathVariable("email") String email) {
//        return userService.getUserByEmail(email);
//    }


    @PostMapping("/users/add")
    public UserDto addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user")
    public UserDto updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PostMapping("users/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserLogin userData) {
        UserDto user = userService.loginUser(userData);
        return ResponseEntity.ok(user);
    }

}
