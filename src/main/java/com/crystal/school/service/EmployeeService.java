package com.crystal.school.service;

import com.crystal.school.dto.EmployeeDto;
import com.crystal.school.dto.EmployeeRegistration;
import com.crystal.school.exception.ItemNotFoundException;
import com.crystal.school.mapper.EmployeeMapper;
import com.crystal.school.model.Employee;
import com.crystal.school.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final PasswordService passwordService = PasswordService.getInstance();
    private final EmployeeMapper employeeMapper = EmployeeMapper.Instance;
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto createEmployee(EmployeeRegistration employeeRegistration) {
        Employee employee = getEmployeeWithPassword(employeeRegistration);
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeDto(employee);

    }

    public List<EmployeeDto> createEmployees(List<EmployeeRegistration> employeeRegistrations) {
        List<Employee> employees = employeeRegistrations.stream().map(this::getEmployeeWithPassword).toList();
        employeeRepository.saveAll(employees);
        return employees.stream().map(employeeMapper::toEmployeeDto).toList();
    }

    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toEmployeeDto).toList();
    }

    public EmployeeDto getEmployeeById(Integer id) {
        return employeeMapper.toEmployeeDto(employeeRepository.findById(id).orElseThrow(ItemNotFoundException::new));
    }

    public EmployeeDto getWorkerByFirstName(String firstName) {
        return employeeMapper.toEmployeeDto(employeeRepository.findByFirstName(firstName));
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void deleteEmployee(EmployeeRegistration employeeRegistration) {
        employeeRepository.deleteById(employeeRegistration.getUserId());
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    public EmployeeDto updateEmployee(EmployeeRegistration employeeRegistration) {
        Employee existingWorker = employeeRepository.findById(employeeRegistration.getUserId()).orElseThrow(ItemNotFoundException::new);
        employeeRepository.save(existingWorker);
        return employeeMapper.toEmployeeDto(existingWorker);
    }

    private Employee getEmployeeWithPassword(EmployeeRegistration teacherRegistration) {
        String plainPassword = teacherRegistration.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.encryptPassword(plainPassword, saltValue);

        teacherRegistration.setPassword(securePassword);
        Employee employee = employeeMapper.toEmployee(teacherRegistration);
        employee.setSalt(saltValue);
        return employee;
    }


}
