package com.crystal.school.dao;

import com.crystal.school.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FakerDataAccessTest {
    FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();
    @Test
    void generateUser(){
        User user = fakerDataAccess.generateUser();
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

    @Test
    void generateEmployee() {
        User employee = fakerDataAccess.generateEmployee();
        Assertions.assertNotNull(employee);
    }
}
