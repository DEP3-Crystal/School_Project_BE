package com.crystal.school.controller;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.model.User;
import com.crystal.school.service.PasswordService;
import com.crystal.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();
    @Autowired
    private UserService userService;

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

    @PostMapping("/user")
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

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) {

        if (userService.loginUser(userData))
            return ResponseEntity.ok(userData);
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
}
