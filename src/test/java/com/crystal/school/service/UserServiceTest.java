package com.crystal.school.service;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.model.User;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {
    FakerDataAccess dataAccess = FakerDataAccess.getInstance();
    @Autowired
    UserService userService;
    @Test
    void saveUser() {
        User user = dataAccess.generateUser();
        userService.saveUser(user);
    }
}