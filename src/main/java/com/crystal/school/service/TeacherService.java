package com.crystal.school.service;


import com.crystal.school.model.Teacher;
import com.crystal.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository userRepository;

    public List<Teacher> getTeachers() {
        return userRepository.findAll();
    }

    public Teacher getTeacherById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

//    public Teacher getTeacherByEmail(String email){
//        return userRepository.findByEmail(email);
//    }

    public Teacher saveTeacher(Teacher user) {
        return userRepository.save(user);
    }


    public String deleteTeacher(Integer id) {
        userRepository.deleteById(id);
        return "user deleted " + id;
    }

    public Teacher updateTeacher(Teacher user) {
        Teacher existingTeacher = userRepository.findById(user.getUserId()).orElse(null);
        existingTeacher.setFirstName(user.getFirstName());
        existingTeacher.setLastName(user.getLastName());
        existingTeacher.setBiography(user.getBiography());
        existingTeacher.setEmail(user.getEmail());
        existingTeacher.setGender(user.getGender());
        existingTeacher.setPassword(user.getPassword());
        existingTeacher.setSalt(user.getSalt());
        return userRepository.save(existingTeacher);
    }
}
