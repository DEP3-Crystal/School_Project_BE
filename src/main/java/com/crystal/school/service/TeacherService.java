package com.crystal.school.service;


import com.crystal.school.dto.TeacherInfoDto;
import com.crystal.school.dto.registration.TeacherRegistrationDto;
import com.crystal.school.exception.ItemNotFoundException;
import com.crystal.school.mapper.TeacherMapper;
import com.crystal.school.model.Teacher;
import com.crystal.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private static final TeacherMapper teacherMapper = TeacherMapper.Instance;
    private final PasswordService passwordService = PasswordService.getInstance();
    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherInfoDto> getTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacherMapper::teacherDto).toList();

    }

    public TeacherInfoDto getTeacherById(Integer id) {
        return teacherMapper.teacherDto(teacherRepository.findById(id).orElse(null));
    }


    public TeacherInfoDto createTeacher(TeacherRegistrationDto teacherRegistrationDto) {
        Teacher teacher = getTeacher(teacherRegistrationDto);
        teacherRepository.save(teacher);
        return TeacherMapper.Instance.teacherDto(teacher);
    }

    private Teacher getTeacher(TeacherRegistrationDto teacherRegistrationDto) {
        String plainPassword = teacherRegistrationDto.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.encryptPassword(plainPassword, saltValue);

        teacherRegistrationDto.setPassword(securePassword);
        Teacher teacher = TeacherMapper.Instance.teacher(teacherRegistrationDto);
        teacher.setSalt(saltValue);
        return teacher;
    }

    public String deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
        return "user deleted " + id;
    }

    public String deleteAllTeachers() {
        teacherRepository.deleteAll();
        return "Teachers deleted";
    }

    public TeacherInfoDto updateTeacher(TeacherRegistrationDto teacherRegistrationDto) {
        validateUser(teacherRegistrationDto);
        Teacher teacher = teacherMapper.teacher(teacherRegistrationDto);
        teacherRepository.save(teacher);
        return teacherMapper.teacherDto(teacher);
    }

    private void validateUser(TeacherRegistrationDto userRegistration) {
        Optional<Teacher> byId = teacherRepository.findById(userRegistration.getId());
        if (byId.isEmpty()) throw new ItemNotFoundException("user not found");
    }

}
