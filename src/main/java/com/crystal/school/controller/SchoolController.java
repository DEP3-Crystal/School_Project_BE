package com.crystal.school.controller;

import com.crystal.school.model.School;
import com.crystal.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class SchoolController {
    @Autowired
    private SchoolService service;


    @GetMapping("/schools")
    public List<School> getSchoolsList(){
        return  service.getSchools();
    }
    @PostMapping("/school")
    public School addSchool(@RequestBody School school){
        return service.saveSchool(school);
    }
    @GetMapping("/schools/{id}")
    public School findSchoolById(@PathVariable int id){
        return service.getSchoolById(id);
    }

    @DeleteMapping("/schools/{id}")
    public String deleteSchool(@PathVariable int id){
        return service.deleteSchool(id);
    }
    @PutMapping("/school")
    public School updateSchool(@RequestBody School school){
        return service.updateSchool(school);
    }
}
