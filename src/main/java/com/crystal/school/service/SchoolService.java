package com.crystal.school.service;

import com.crystal.school.model.School;
import com.crystal.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public School getSchoolById(int id) {
        return schoolRepository.findById(id).orElse(null);
    }

    public String deleteSchool(int id) {
        schoolRepository.deleteById(id);
        return "school deleted " + id;
    }
    public School updateSchool(School school) {
        School existingSchool = schoolRepository.findById(school.getBuildingId()).orElse(null);
        existingSchool.setLocation(school.getLocation());
        existingSchool.setName(school.getName());

        return schoolRepository.save(existingSchool);
    }
}
