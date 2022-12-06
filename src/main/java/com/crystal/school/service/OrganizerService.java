package com.crystal.school.service;

import com.crystal.school.model.Organizer;
import com.crystal.school.model.Worker;
import com.crystal.school.repository.OrganizerRepository;
import com.crystal.school.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;


    public Organizer saveOrganizer(Organizer organizer){
        return organizerRepository.save(organizer);
    }
    public List<Organizer> saveOrganizers(List<Organizer> organizers){
        return organizerRepository.saveAll(organizers);
    }

    public List<Organizer> getOrganizers(){
        return organizerRepository.findAll();
    }
    public Organizer getOrganizerById(Integer id){
        return organizerRepository.findById(id).orElse(null);
    }
    public Organizer getOrganizerByFirstName(String firstName){
        return organizerRepository.findByFirstName(firstName);
    }
    public String deleteOrganizerById(Integer id){
        organizerRepository.deleteById(id);
        return "Organizer deleted: "+id;
    }
    public void deleteOrganizer(Organizer organizer){
        organizerRepository.delete(organizer);
    }
    public void deleteAllOrganizers(){
        organizerRepository.deleteAll();
    }
    public Organizer updateOrganizer(Organizer organizer){
        Organizer existingOrganizer = organizerRepository.findById(organizer.getUserId()).orElse(null);
        existingOrganizer.setFirstName(organizer.getFirstName());
        existingOrganizer.setLastName(organizer.getLastName());
        existingOrganizer.setBiography(organizer.getBiography());
        existingOrganizer.setEmail(organizer.getEmail());
        existingOrganizer.setGender(organizer.getGender());
        existingOrganizer.setPassword(organizer.getPassword());
        existingOrganizer.setStatus(organizer.getStatus());
        return organizerRepository.save(existingOrganizer);
    }

}
