package com.crystal.school.controller;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.model.User;
import com.crystal.school.model.UserLogin;
import com.crystal.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
    private final FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();


    @GetMapping("/")
    public List<User> getUserList() {
        //return fakerDataAccess.generateUsers(500);
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

//        @GetMapping("/user")
//    public User getUserByEmailAndPassword(@RequestBody UserLoginDto user){
//        return userService.getUserByEmailAndPassword(user.getEmail(),user.getPassword());
//    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody UserLogin userLogin) {
        return this.userService.getUserByEmailAndPassword(userLogin.getEmail(),userLogin.getPassword());
//        System.out.println(userData);
//        User user = userService.getUserById(userData.getUserId());
//        if (user.getPassword().equals(userData.getPassword()))
//            return ResponseEntity.ok(user);
//        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }
}
