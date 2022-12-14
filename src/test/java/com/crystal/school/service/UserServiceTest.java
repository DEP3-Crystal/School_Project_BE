package com.crystal.school.service;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.model.Employee;
import com.crystal.school.model.User;
import org.junit.jupiter.api.Assertions;
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
        User user = dataAccess.generateUser();
        userService.saveUser(user);
    }

    @Test
    void saveEmployee() {
        Employee employee = dataAccess.generateEmployee();
        var saved = userService.saveUser(employee);
        Assertions.assertEquals(employee,saved);

    }
}