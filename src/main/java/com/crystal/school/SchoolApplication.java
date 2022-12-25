package com.crystal.school;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.repository.SchoolRepository;
import com.crystal.school.service.FakerDataAccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private FakerDataAccessService fakerDataAccessService;
    @Autowired
    private SchoolRepository schoolRepository;
    FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        fakerDataAccessService.insertDummyData();
    }
}
