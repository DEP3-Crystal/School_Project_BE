package com.crystal.school.controller;

import com.crystal.school.dao.FakerDataAccess;
import com.crystal.school.dto.SchoolDto;
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

    @GetMapping("/schools")
    public List<SchoolDto> getSchoolsList() {
        return service.getSchools();
    }

    @PostMapping("/school")
    public SchoolDto addSchool(@RequestBody SchoolDto school) {
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
    public SchoolDto updateSchool(@RequestBody SchoolDto school) {
        return service.updateSchool(school);
    }
}
