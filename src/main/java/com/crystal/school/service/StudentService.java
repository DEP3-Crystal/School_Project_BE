package com.crystal.school.service;


import com.crystal.school.dto.StudentInfoDto;
import com.crystal.school.dto.UserLogin;
import com.crystal.school.dto.registration.StudentRegistrationDto;
import com.crystal.school.dto.registration.UserRegistrationDto;
import com.crystal.school.exception.ResourceNotFoundException;
import com.crystal.school.exception.UserTakenException;
import com.crystal.school.mapper.StudentMapper;
import com.crystal.school.model.Student;
import com.crystal.school.model.enums.Role;
import com.crystal.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final PasswordService passwordService = PasswordService.getInstance();
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper mapper;

    public List<StudentInfoDto> getUsers() {
        List<Student> users = studentRepository.findAll();
        return users.stream().map(mapper::toStudentDto).toList();
    }

    public StudentInfoDto getUserById(Integer id) {
        return mapper.toStudentDto(studentRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }


    public StudentInfoDto createUser(StudentRegistrationDto userRegistration) {
        validateEmail(userRegistration.getEmail());
        Student student = fillUserData(userRegistration);
        studentRepository.save(student);
        return mapper.toStudentDto(studentRepository.save(student));
    }

    private void validateEmail(String email) {
        studentRepository.findByEmail(email).orElseThrow(() -> new UserTakenException("this email is taken by another user"));
    }

    private Student fillUserData(StudentRegistrationDto userRegistration) {
        String plainPassword = userRegistration.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.encryptPassword(plainPassword, saltValue);

        userRegistration.setPassword(securePassword);
        Student user = mapper.toStudent(userRegistration);
        user.setSalt(saltValue);
        return user;
    }



    public String deleteUser(Integer id) {
        studentRepository.deleteById(id);
        return "user deleted " + id;
    }

    public StudentInfoDto updateUser(StudentInfoDto userRegistration) {
        validateUser(userRegistration);
        Student user = mapper.toStudent(userRegistration);
        Student save = studentRepository.save(user);
        return mapper.toStudentDto(save);
    }

    private void validateUser(StudentInfoDto userRegistration) {
        var user = studentRepository.findById(userRegistration.getId());
        if (user.isEmpty()) throw new ResourceNotFoundException("Student not found!");
    }


}
