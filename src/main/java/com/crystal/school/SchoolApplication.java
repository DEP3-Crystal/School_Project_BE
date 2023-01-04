package com.crystal.school;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.model.School;
import com.crystal.school.repository.SchoolRepository;
import com.crystal.school.repository.SessionRatingRepository;
import com.crystal.school.service.FakerDataAccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(getClass());

    FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();


    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        fakerDataAccessService.insertDummyData();
    }
}
