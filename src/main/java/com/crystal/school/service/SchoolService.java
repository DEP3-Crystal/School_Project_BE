package com.crystal.school.service;

import com.crystal.school.model.School;
import com.crystal.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository repository;

    public List<School> getSchools() {
        return repository.findAll();
    }
    public School saveSchool(School school) {
        return repository.save(school);
    }

    public School getSchoolById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteSchool(int id) {
        repository.deleteById(id);
        return "school deleted " + id;
    }
    public School updateSchool(School school) {
        School existingSchool = repository.findById(school.getBuilding_id()).orElse(null);
        existingSchool.setLocation(school.getLocation());
        existingSchool.setName(school.getName());

        return repository.save(existingSchool);
    }
}
