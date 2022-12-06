package com.crystal.school.controller;

import com.crystal.school.model.Organizer;
import com.crystal.school.model.Worker;
import com.crystal.school.service.OrganizerService;
import com.crystal.school.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;


    @GetMapping("/organizer/{id}")
    public Worker getOrganizerById(@PathVariable Integer id){
        return organizerService.getOrganizerById(id);
    }
    @GetMapping("/organizers")
    public List<Organizer> getAllOrganizers(){
        return organizerService.getOrganizers();
    }
    @PostMapping("/organizer")
    public String addOrganizer(@RequestBody Organizer organizer){
        organizerService.saveOrganizer(organizer);
        return "Added successfully";
    }
    @PostMapping("/organizers")
    public String addOrganizers(@RequestBody List<Organizer> organizers){
        organizerService.saveOrganizers(organizers);
        return "Added successfully";
    }
    @PutMapping("/organizer")
    public String updateOrganizer(@RequestBody Organizer organizer){
        organizerService.updateOrganizer(organizer);
        return "Updated successfully";
    }
    @DeleteMapping("/organizer/{id}")
    public String deleteOrganizerById(@PathVariable Integer id){
        organizerService.deleteOrganizerById(id);
        return "Deleted successfully";
    }
    @DeleteMapping("/organizer")
    public String deleteOrganizer(@RequestBody Organizer organizer){
        organizerService.deleteOrganizer(organizer);
        return "Deleted successfully";
    }
    @DeleteMapping("/organizers")
    public String deleteOrganizers(){
        organizerService.deleteAllOrganizers();
        return "Deleted successfully all organizers";
    }
}
