package com.crystal.school.controller;

import com.crystal.school.model.User;
import com.crystal.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.getUsers();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
