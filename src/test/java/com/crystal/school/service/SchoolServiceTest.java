package com.crystal.school.service;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.model.School;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolServiceTest {
    FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();
    @Autowired
    SchoolService schoolService;

    @Test
    void saveSchool() {
        List<School> schools = fakerDataAccess.generateSchools(2, 20, 30, 50, 200);
        for (School school : schools) {
            var r = schoolService.saveSchool(school);
            Assertions.assertNotNull(r);
        }

    }
}