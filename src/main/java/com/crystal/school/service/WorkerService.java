package com.crystal.school.service;

import com.crystal.school.model.Worker;
import com.crystal.school.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;


    public Worker saveWorker(Worker worker){
        return workerRepository.save(worker);
    }
    public List<Worker> saveWorkers(List<Worker> workers){
        return workerRepository.saveAll(workers);
    }

    public List<Worker> getWorkers(){
        return workerRepository.findAll();
    }
    public Worker getWorkerById(Integer id){
        return workerRepository.findById(id).orElse(null);
    }
    public Worker getWorkerByFirstName(String firstName){
        return workerRepository.findByFirstName(firstName);
    }
    public String deleteWorkerById(Integer id){
        workerRepository.deleteById(id);
        return "Worker deleted: "+id;
    }
    public void deleteWorker(Worker worker){
        workerRepository.delete(worker);
    }
    public void deleteAllWorkers(){
        workerRepository.deleteAll();
    }
    public Worker updateWorker(Worker worker){
        Worker existingWorker = workerRepository.findById(worker.getUserId()).orElse(null);
        existingWorker.setFirstName(worker.getFirstName());
        existingWorker.setLastName(worker.getLastName());
        existingWorker.setBiography(worker.getBiography());
        existingWorker.setEmail(worker.getEmail());
        existingWorker.setGender(worker.getGender());
        existingWorker.setPassword(worker.getPassword());
        existingWorker.setStatus(worker.getStatus());
        return workerRepository.save(existingWorker);
    }

}
