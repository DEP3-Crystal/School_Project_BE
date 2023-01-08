package com.crystal.school.controller;

import com.crystal.school.dto.StudentInfoDto;
import com.crystal.school.dto.UserInfoDto;
import com.crystal.school.dto.UserLogin;
import com.crystal.school.dto.registration.StudentRegistrationDto;
import com.crystal.school.dto.registration.UserRegistrationDto;
import com.crystal.school.service.LoginService;
import com.crystal.school.service.StudentService;
import com.crystal.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService userService;
    @Autowired
    private LoginService loginService;

    @GetMapping("")
    public List<StudentInfoDto> getUserList() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserInfoDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }


    @PostMapping("/add")
    public UserInfoDto addUser(@RequestBody StudentRegistrationDto user) {
        return userService.createUser(user);
    }

    @PutMapping("/updateInfo")
    public UserInfoDto updateUser(@RequestBody StudentInfoDto user) {
        return userService.updateUser(user);
    }



}
