package com.crystal.school.service;

import com.crystal.school.model.Student;
import com.crystal.school.model.Teacher;
import com.crystal.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public List<Teacher> saveTeachers(List<Teacher> teachers){
        return teacherRepository.saveAll(teachers);
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    public Teacher getTeacherById(Integer id){
        return teacherRepository.findById(id).orElse(null);
    }
    public Teacher getTeacherByFirstName(String firstName){
        return teacherRepository.findByFirstName(firstName);
    }
    public String deleteTeacherById(Integer id){
        teacherRepository.deleteById(id);
        return "Teacher deleted: "+id;
    }
    public void deleteTeacher(Teacher teacher){
        teacherRepository.delete(teacher);
    }
    public void deleteAllTeachers(){
        teacherRepository.deleteAll();
    }
    public Teacher updateTeacher(Teacher teacher){
        Teacher existingTeacher = teacherRepository.findById(teacher.getUserId()).orElse(null);
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setBiography(teacher.getBiography());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setGender(teacher.getGender());
        existingTeacher.setPassword(teacher.getPassword());
        existingTeacher.setStatus(teacher.getStatus());
        return teacherRepository.save(existingTeacher);
    }
}
