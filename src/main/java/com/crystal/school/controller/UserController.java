package com.crystal.school.controller;

import com.crystal.school.dao.FakerDataAccess;
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

    @PostMapping("users/login")
    public ResponseEntity<User> loginUser(@RequestBody UserLogin userData) {

        User user = userService.getUserByEmailAndPassword(userData.getEmail(),userData.getPassword());
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
//        if (loginService.validateUser(user, userData.getPassword()))
//            return ResponseEntity.ok(user);

    }
}
