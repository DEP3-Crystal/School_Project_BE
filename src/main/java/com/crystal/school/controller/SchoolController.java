package com.crystal.school.controller;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.dto_old.SchoolDto;
import com.crystal.school.model.School;
import com.crystal.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/")
public class SchoolController {
    @Autowired
    private SchoolService service;
    private final FakerDataAccess fakerDataAccess = FakerDataAccess.getInstance();

    @GetMapping("/schools")
    public List<SchoolDto> getSchoolsList() {
        // return fakerDataAccess.generateSchools(1, 1, 1, 1, 1);
        return service.getSchools();
    }

    @PostMapping("/school")
    public SchoolDto addSchool(@RequestBody School school) {
        return service.saveSchool(school);
    }

    @GetMapping("/schools/{id}")
    public SchoolDto findSchoolById(@PathVariable int id) {
        return service.getSchoolById(id);
    }

    @DeleteMapping("/schools/{id}")
    public String deleteSchool(@PathVariable int id) {
        return service.deleteSchool(id);
    }

    @PutMapping("/school")
    public SchoolDto updateSchool(@RequestBody School school) {
        return service.updateSchool(school);
    }
}
