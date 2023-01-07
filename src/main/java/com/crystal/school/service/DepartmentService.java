package com.crystal.school.service;

import com.crystal.school.dto_old.DepartmentDto;
import com.crystal.school.exception.ResourceNotFoundException;
import com.crystal.school.mapper.DepartmentMapper;
import com.crystal.school.model.Department;
import com.crystal.school.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentDto getDepartmentById(Integer id) {
        return DepartmentMapper.Instance.toDepartmentDto(departmentRepository.findById(id).orElse(null));
    }

    public List<DepartmentDto> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentMapper.Instance::toDepartmentDto).toList();
    }

    public DepartmentDto addDepartment(Department department) {

        return DepartmentMapper.Instance.toDepartmentDto(departmentRepository.save(department));
    }

    public List<DepartmentDto> addDepartments(List<Department> departments) {
        departmentRepository.saveAll(departments);
        return departments.stream().map(DepartmentMapper.Instance::toDepartmentDto).toList();
    }

    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);
    }

    public void deleteAllDepartments() {
        departmentRepository.deleteAll();
    }

    public DepartmentDto editDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getDepartmentId()).orElseThrow(ResourceNotFoundException::new);
        existingDepartment.setDepartmentId(department.getDepartmentId());
        existingDepartment.setName(department.getName());
        existingDepartment.setEmployee(department.getEmployee());
        existingDepartment.setSessions(department.getSessions());
        existingDepartment.setTeachers(department.getTeachers());
        existingDepartment.setStudents(department.getStudents());

        return DepartmentMapper.Instance.toDepartmentDto(departmentRepository.save(existingDepartment));
    }
}
