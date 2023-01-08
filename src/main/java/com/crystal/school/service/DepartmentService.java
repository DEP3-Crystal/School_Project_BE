package com.crystal.school.service;

import com.crystal.school.dto.DepartmentDto;
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
    private static final DepartmentMapper mapper = DepartmentMapper.Instance;

    public DepartmentDto getDepartmentById(Integer id) {
        return mapper.toDepartmentDto(departmentRepository.findById(id).orElse(null));
    }

    public List<DepartmentDto> getDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(mapper::toDepartmentDto).toList();
    }

    public DepartmentDto addDepartment(DepartmentDto department) {

        Department savedDepartment = departmentRepository.save(mapper.toDepartment(department));
        return mapper.toDepartmentDto(savedDepartment);
    }

    public List<DepartmentDto> addDepartments(List<DepartmentDto> departmentsDto) {
        List<Department> departments = departmentsDto.stream().map(mapper::toDepartment).toList();
        List<Department> savedDep = departmentRepository.saveAll(departments);
        return savedDep.stream().map(mapper::toDepartmentDto).toList();
    }

    public void deleteDepartmentById(Integer id) {
        departmentRepository.deleteById(id);
    }

    public void deleteAllDepartments() {
        departmentRepository.deleteAll();
    }

    public DepartmentDto editDepartment(DepartmentDto department) {
        Department existingDepartment = departmentRepository.findById(department.getDepartmentId())
                .orElseThrow(ResourceNotFoundException::new);
        return mapper.toDepartmentDto(departmentRepository.save(existingDepartment));
    }
}
