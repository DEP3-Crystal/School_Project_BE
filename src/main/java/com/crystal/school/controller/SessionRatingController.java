package com.crystal.school.controller;

import com.crystal.school.model.SessionRating;
import com.crystal.school.model.id.SessionRatingId;
import com.crystal.school.service.SessionRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SessionRatingController {
  @Autowired
    private SessionRatingService sessionRatingService;


    @GetMapping("/session-rating/{id}")
    public SessionRating getSessionRatingById(@PathVariable SessionRatingId id){
        return sessionRatingService.getSessionRatingById(id);
    }
    @GetMapping("/session-ratings")
    public List<SessionRating> getAllSessionRatings(){
        return sessionRatingService.getSessionRatings();
    }
    @PostMapping("/session-rating")
    public String addSessionRating(@RequestBody SessionRating sessionRating){
        sessionRatingService.saveSessionRating(sessionRating);
        return "Added successfully";
    }
    //TODO find out why it is duplicated what is missing
//    @PostMapping("/session-rating")
//    public String addSessionRatings(@RequestBody List<SessionRating> sessionRatings){
//        sessionRatingService.saveSessionRatings(sessionRatings);
//        return "Added successfully";
//    }
    @PutMapping("/session-rating")
    public String editSessionRating(@RequestBody SessionRating sessionRating){
        sessionRatingService.editSessionRating(sessionRating);
        return "Updated successfully";
    }
    @DeleteMapping("/session-rating")
    public String deleteSessionRating(@RequestBody SessionRating sessionRating){
        sessionRatingService.deleteSessionRating(sessionRating);
        return "Deleted successfully";
    }
    @DeleteMapping("/session-rating/{id}")
    public String deleteSessionRating(@PathVariable SessionRatingId id){
        sessionRatingService.deleteSessionRatingById(id);
        return "Deleted successfully";
    }


    @DeleteMapping("/session-ratings")
    public String deleteSessionRatings(){
        sessionRatingService.deleteAllSessionRatings();
        return "Deleted successfully all ratings";
    }
}
