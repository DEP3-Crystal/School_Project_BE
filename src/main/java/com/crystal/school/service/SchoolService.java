package com.crystal.school.service;

import com.crystal.school.dto.SchoolDto;
import com.crystal.school.exception.ResourceNotFoundException;
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
    private static final SchoolMapper mapper = SchoolMapper.Instance;

    public List<SchoolDto> getSchools() {
        return schoolRepository.findAll().stream().map(mapper::toSchoolDto).toList();
    }

    public SchoolDto saveSchool(SchoolDto school) {
        School savedSchool = schoolRepository.save(mapper.toSchool(school));
        return mapper.toSchoolDto(savedSchool);
    }

    public SchoolDto getSchoolById(int id) {
        return mapper.toSchoolDto(schoolRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public String deleteSchool(int id) {
        schoolRepository.deleteById(id);
        return "school deleted " + id;
    }

    public SchoolDto updateSchool(SchoolDto schoolDto) {
        if (!schoolRepository.existsById(schoolDto.getSchoolId()))
            throw new ResourceNotFoundException("school not found");

        School savedSchool = schoolRepository.save(mapper.toSchool(schoolDto));
        return mapper.toSchoolDto(savedSchool);
    }
}
