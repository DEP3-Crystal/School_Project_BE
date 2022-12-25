package com.crystal.school.service;

import com.crystal.school.dto.SchoolDto;
import com.crystal.school.exception.ItemNotFoundException;
import com.crystal.school.mapper.SchoolMapper;
import com.crystal.school.model.School;
import com.crystal.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<SchoolDto> getSchools() {
        return schoolRepository.findAll().stream().map(SchoolMapper.Instance::toSchoolDto).toList();
    }

    public SchoolDto saveSchool(School school) {
        schoolRepository.save(school);
        return SchoolMapper.Instance.toSchoolDto(schoolRepository.save(school));
    }

    public SchoolDto getSchoolById(int id) {
        return SchoolMapper.Instance.toSchoolDto(schoolRepository.findById(id).orElseThrow(ItemNotFoundException::new));
    }

    public String deleteSchool(int id) {
        schoolRepository.deleteById(id);
        return "school deleted " + id;
    }

    public SchoolDto updateSchool(School school) {
        School existingSchool = schoolRepository.findById(school.getSchoolId()).orElseThrow(ItemNotFoundException::new);
        existingSchool.setRooms(school.getRooms());
        existingSchool.setLocation(school.getLocation());
        existingSchool.setName(school.getName());

        return SchoolMapper.Instance.toSchoolDto(schoolRepository.save(existingSchool));
    }
}
