package com.crystal.school.service;


import com.crystal.school.dto.TeacherDto;
import com.crystal.school.dto.TeacherRegistration;
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

    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(teacherMapper::teacherDto).toList();

    }

    public TeacherDto getTeacherById(Integer id) {
        return teacherMapper.teacherDto(teacherRepository.findById(id).orElse(null));
    }


    public TeacherDto createTeacher(TeacherRegistration teacherRegistration) {
        Teacher teacher = getTeacher(teacherRegistration);
        teacherRepository.save(teacher);
        return TeacherMapper.Instance.teacherDto(teacher);
    }

    private Teacher getTeacher(TeacherRegistration teacherRegistration) {
        String plainPassword = teacherRegistration.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.encryptPassword(plainPassword, saltValue);

        teacherRegistration.setPassword(securePassword);
        Teacher teacher = TeacherMapper.Instance.teacher(teacherRegistration);
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

    public TeacherDto updateTeacher(TeacherRegistration teacherRegistration) {
        validateUser(teacherRegistration);
        Teacher teacher = teacherMapper.teacher(teacherRegistration);
        teacherRepository.save(teacher);
        return teacherMapper.teacherDto(teacher);
    }

    private void validateUser(TeacherRegistration userRegistration) {
        Optional<Teacher> byId = teacherRepository.findById(userRegistration.getUserId());
        if (byId.isEmpty()) throw new ItemNotFoundException("user not found");
    }

}
