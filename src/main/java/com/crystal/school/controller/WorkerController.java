package com.crystal.school.controller;

import com.crystal.school.model.Worker;
import com.crystal.school.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;


    @GetMapping("/worker/{id}")
    public Worker getWorkerById(@PathVariable Integer id){
        return workerService.getWorkerById(id);
    }
    @GetMapping("/workers")
    public List<Worker> getAllWorkers(){
        return workerService.getWorkers();
    }
    @PostMapping("/worker")
    public String addWorker(@RequestBody Worker worker){
         workerService.saveWorker(worker);
         return "Added successfully";
    }
    @PostMapping("/workers")
    public String addWorkers(@RequestBody List<Worker> workers){
        workerService.saveWorkers(workers);
        return "Added successfully";
    }
    @PutMapping("/worker")
    public String updateWorker(@RequestBody Worker worker){
        workerService.updateWorker(worker);
        return "Updated successfully";
    }
    @DeleteMapping("/worker/{id}")
    public String deleteWorkerById(@PathVariable Integer id){
        workerService.deleteWorkerById(id);
        return "Deleted successfully";
    }
    @DeleteMapping("/worker")
    public String deleteWorker(@RequestBody Worker worker){
        workerService.deleteWorker(worker);
        return "Deleted successfully";
    }
    @DeleteMapping("/workers")
    public String deleteWorkers(){
        workerService.deleteAllWorkers();
        return "Deleted successfully all workers";
    }

}
