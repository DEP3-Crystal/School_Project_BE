package com.crystal.school.controller;

import com.crystal.school.dto.pivote.TeacherRatingDto;
import com.crystal.school.model.id.TeacherRatingId;
import com.crystal.school.model.pivote.TeacherRating;
import com.crystal.school.service.TeacherRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherRatingController {
    @Autowired
    private TeacherRatingService teacherRatingService;

    @GetMapping("/teacher-rating/{id}")
    public TeacherRatingDto getTeacherRatingById(@PathVariable TeacherRatingId id) {
        return teacherRatingService.getTeacherRatingById(id);
    }

    @GetMapping("/teacher-ratings")
    public List<TeacherRatingDto> getAllTeacherRatings() {
        return teacherRatingService.getTeacherRatings();
    }

    @PostMapping("/teacher-rating")
    public String addTeacherRating(@RequestBody TeacherRating teacherRating) {
        teacherRatingService.saveTeacherRating(teacherRating);
        return "Added successfully";
    }

    @PostMapping("/teachers-rating")
    public String addTeacherRatings(@RequestBody List<TeacherRating> teacherRatings) {
        teacherRatingService.saveTeacherRatings(teacherRatings);
        return "Added successfully";
    }

    @PutMapping("/teacher-rating")
    public String editTeacherRating(@RequestBody TeacherRating teacherRating) {
        teacherRatingService.editTeacherRating(teacherRating);
        return "Updated successfully";
    }

    @DeleteMapping("/teacher-rating/{id}")
    public String deleteTeacherRating(@PathVariable TeacherRatingId id) {
        teacherRatingService.deleteTeacherRatingById(id);
        return "Deleted successfully";
    }

    @DeleteMapping("/teacher-rating")
    public String deleteTeacherRating(@RequestBody TeacherRating teacherRating) {
        teacherRatingService.deleteTeacherRating(teacherRating);
        return "Deleted successfully";
    }

    @DeleteMapping("/teacher-ratings")
    public String deleteTeacherRatings() {
        teacherRatingService.deleteAllTeacherRatings();
        return "Deleted successfully all ratings";
    }
}
