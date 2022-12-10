package com.crystal.school.service;

import com.crystal.school.model.Department;
import com.crystal.school.model.StudentRegistration;
import com.crystal.school.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getDepartmentById(Integer id){
         return departmentRepository.findById(id).orElse(null);
    }
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }
    public Department addDepartment(Department department){
      return departmentRepository.save(department);
    }
    public List<Department> addDepartments(List<Department> departments){
         return departmentRepository.saveAll(departments);
    }
    public void deleteDepartment(Department department){
        departmentRepository.delete(department);
    }
    public void deleteDepartmentById(Integer id){
        departmentRepository.deleteById(id);
    }
    public void deleteAllDepartments(){
        departmentRepository.deleteAll();
    }

    public Department editDepartment(Department department){
        Department existingDepartment = departmentRepository.findById(department.getDepartmentId()).orElse(null);
        existingDepartment.setDepartmentId(department.getDepartmentId());
        existingDepartment.setName(department.getName());
        existingDepartment.setOrganizer(department.getOrganizer());
        existingDepartment.setSessions(department.getSessions());
        existingDepartment.setTeachers(department.getTeachers());
        existingDepartment.setOrganizerId(department.getOrganizerId());
        existingDepartment.setStudents(department.getStudents());

        return departmentRepository.save(existingDepartment);
    }
}
