package com.crystal.school.service;


import com.crystal.school.dto.TeacherDto;
import com.crystal.school.mapper.TeacherMapper;
import com.crystal.school.model.Teacher;
import com.crystal.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherDto> getTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers.stream().map(TeacherMapper.Instance::teacherDto).toList();

    }

    public TeacherDto getTeacherById(Integer id) {
        return TeacherMapper.Instance.teacherDto(teacherRepository.findById(id).orElse(null));
    }


    public TeacherDto saveTeacher(Teacher user) {
        return TeacherMapper.Instance.teacherDto(teacherRepository.save(user));
    }


    public String deleteTeacher(Integer id) {
        teacherRepository.deleteById(id);
        return "user deleted " + id;
    }

    public String deleteAllTeachers() {
        teacherRepository.deleteAll();
        return "Teachers deleted";
    }

    public TeacherDto updateTeacher(Teacher user) {
        Teacher existingTeacher = teacherRepository.findById(user.getUserId()).orElse(null);
        existingTeacher.setFirstName(user.getFirstName());
        existingTeacher.setLastName(user.getLastName());
        existingTeacher.setBiography(user.getBiography());
        existingTeacher.setEmail(user.getEmail());
        existingTeacher.setGender(user.getGender());
        existingTeacher.setPassword(user.getPassword());
        existingTeacher.setSalt(user.getSalt());
        return TeacherMapper.Instance.teacherDto(teacherRepository.save(existingTeacher));
    }
}
