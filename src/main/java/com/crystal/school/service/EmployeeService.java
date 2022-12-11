package com.crystal.school.service;

import com.crystal.school.model.Employee;
import com.crystal.school.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee saveWorker(Employee worker){
        return employeeRepository.save(worker);
    }
    public List<Employee> saveWorkers(List<Employee> workers){
        return employeeRepository.saveAll(workers);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee getWorkerByFirstName(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }
    public String deleteWorkerById(Integer id){
        employeeRepository.deleteById(id);
        return "Employee deleted: "+id;
    }
    public void deleteWorker(Employee worker){
        employeeRepository.delete(worker);
    }
    public void deleteAllWorkers(){
        employeeRepository.deleteAll();
    }
    public Employee updateWorker(Employee worker){
        Employee existingWorker = employeeRepository.findById(worker.getUserId()).orElse(null);
        existingWorker.setFirstName(worker.getFirstName());
        existingWorker.setLastName(worker.getLastName());
        existingWorker.setBiography(worker.getBiography());
        existingWorker.setEmail(worker.getEmail());
        existingWorker.setGender(worker.getGender());
        existingWorker.setPassword(worker.getPassword());
        existingWorker.setRole(worker.getRole());
        return employeeRepository.save(existingWorker);
    }

}
