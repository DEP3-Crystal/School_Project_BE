package com.crystal.school.service;

import com.crystal.school.dao.FakerDataAccess;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {
    FakerDataAccess dataAccess = FakerDataAccess.getInstance();
    @Autowired
    UserService userService;

    @Test
    void saveUser() {
//        User user = dataAccess.generateUser();
//        var saved = userService.createUser(user);
//        user.setUserId(saved.getUserId());
//        Assertions.assertEquals(user, saved);

    }

    @Test
    void saveEmployee() {
//        Employee employee = dataAccess.generateEmployee();
//        var saved = userService.createUser(employee);
//        Assertions.assertEquals(employee, saved);

    }
}