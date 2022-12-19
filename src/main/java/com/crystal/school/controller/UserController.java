package com.crystal.school.controller;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.dto.UserDto;
import com.crystal.school.mapper.UserMapper;
import com.crystal.school.model.User;
import com.crystal.school.model.UserLogin;
import com.crystal.school.service.LoginService;
import com.crystal.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<User> getUserList() {
        //return fakerDataAccess.generateUsers(500);
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }


    @PostMapping("/users/add")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PostMapping("users/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserLogin userData) {

        User user = userService.getUserByEmail(userData.getEmail());

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (loginService.validateUser(user, userData.getPassword())) {
            return ResponseEntity.ok(UserMapper.Instance.userDto(user));
        }
        return new ResponseEntity<>(UserMapper.Instance.userDto(user), HttpStatus.NOT_FOUND);
    }

}
