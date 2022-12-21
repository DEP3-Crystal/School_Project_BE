package com.crystal.school.service;

import com.crystal.school.dto.EmployeeDto;
import com.crystal.school.mapper.EmployeeMapper;
import com.crystal.school.model.Employee;
import com.crystal.school.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeDto saveWorker(Employee worker) {
        employeeRepository.save(worker);
        return EmployeeMapper.Instance.toEmployeeDto(worker);

    }

    public List<EmployeeDto> saveWorkers(List<Employee> workers) {
        employeeRepository.saveAll(workers);
        return workers.stream().map(EmployeeMapper.Instance::toEmployeeDto).toList();
    }

    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper.Instance::toEmployeeDto).toList();
    }

    public EmployeeDto getEmployeeById(Integer id) {
        return EmployeeMapper.Instance.toEmployeeDto(employeeRepository.findById(id).orElse(null));
    }

    public EmployeeDto getWorkerByFirstName(String firstName) {

        return EmployeeMapper.Instance.toEmployeeDto(employeeRepository.findByFirstName(firstName));
    }

    public String deleteWorkerById(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee deleted: " + id;
    }

    public void deleteWorker(Employee worker) {
        employeeRepository.delete(worker);
    }

    public void deleteAllWorkers() {
        employeeRepository.deleteAll();
    }

    public EmployeeDto updateWorker(Employee worker) {
        Employee existingWorker = employeeRepository.findById(worker.getUserId()).orElse(null);
        existingWorker.setFirstName(worker.getFirstName());
        existingWorker.setLastName(worker.getLastName());
        existingWorker.setBiography(worker.getBiography());
        existingWorker.setEmail(worker.getEmail());
        existingWorker.setGender(worker.getGender());
        existingWorker.setPassword(worker.getPassword());
        existingWorker.setRole(worker.getRole());
        employeeRepository.save(existingWorker);
        return EmployeeMapper.Instance.toEmployeeDto(existingWorker);
    }

}
