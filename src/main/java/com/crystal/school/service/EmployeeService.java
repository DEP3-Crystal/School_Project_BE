package com.crystal.school.service;

import com.crystal.school.dto_old.EmployeeInfoDto;
import com.crystal.school.dto_old.registration.EmployeeRegistrationDto;
import com.crystal.school.exception.ResourceNotFoundException;
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

    public EmployeeInfoDto createEmployee(EmployeeRegistrationDto employeeRegistrationDto) {
        Employee employee = getEmployeeWithPassword(employeeRegistrationDto);
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeDto(employee);

    }

    public List<EmployeeInfoDto> createEmployees(List<EmployeeRegistrationDto> employeeRegistrationDtos) {
        List<Employee> employees = employeeRegistrationDtos.stream().map(this::getEmployeeWithPassword).toList();
        employeeRepository.saveAll(employees);
        return employees.stream().map(employeeMapper::toEmployeeDto).toList();
    }

    public List<EmployeeInfoDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::toEmployeeDto).toList();
    }

    public EmployeeInfoDto getEmployeeById(Integer id) {
        return employeeMapper.toEmployeeDto(employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public EmployeeInfoDto getWorkerByFirstName(String firstName) {
        return employeeMapper.toEmployeeDto(employeeRepository.findByFirstName(firstName));
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void deleteEmployee(EmployeeRegistrationDto employeeRegistrationDto) {
        employeeRepository.deleteById(employeeRegistrationDto.getId());
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    public EmployeeInfoDto updateEmployee(EmployeeRegistrationDto employeeRegistrationDto) {
        Employee existingWorker = employeeRepository.findById(employeeRegistrationDto.getId()).orElseThrow(ResourceNotFoundException::new);
        employeeRepository.save(existingWorker);
        return employeeMapper.toEmployeeDto(existingWorker);
    }

    private Employee getEmployeeWithPassword(EmployeeRegistrationDto teacherRegistration) {
        String plainPassword = teacherRegistration.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.encryptPassword(plainPassword, saltValue);

        teacherRegistration.setPassword(securePassword);
        Employee employee = employeeMapper.toEmployee(teacherRegistration);
        employee.setSalt(saltValue);
        return employee;
    }


}
