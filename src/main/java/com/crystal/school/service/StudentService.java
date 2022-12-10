package com.crystal.school.service;

import com.crystal.school.model.Student;
import com.crystal.school.model.Worker;
import com.crystal.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public List<Student> saveStudents(List<Student> students){
        return studentRepository.saveAll(students);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }
    public Student getStudentByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }
    public String deleteStudentById(Integer id){
        studentRepository.deleteById(id);
        return "Student deleted: "+id;
    }
    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }
    public void deleteAllStudents(){
        studentRepository.deleteAll();
    }
    public Student updateStudent(Student student){
        Student existingStudent = studentRepository.findById(student.getUserId()).orElse(null);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setBiography(student.getBiography());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setGender(student.getGender());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setStatus(student.getStatus());
        return studentRepository.save(existingStudent);
    }

}
