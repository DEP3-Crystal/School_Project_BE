package com.crystal.school.service;

import com.crystal.school.model.id.TeacherRatingId;
import com.crystal.school.model.pivote.TeacherRating;
import com.crystal.school.repository.TeacherRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherRatingService {
    @Autowired
    private TeacherRatingRepository teacherRatingRepository;

    public TeacherRating saveTeacherRating(TeacherRating teacherRating) {
        return teacherRatingRepository.save(teacherRating);
    }

    public List<TeacherRating> saveTeacherRatings(List<TeacherRating> teacherRatings) {
        return teacherRatingRepository.saveAll(teacherRatings);
    }

    public List<TeacherRating> getTeacherRatings() {
        return teacherRatingRepository.findAll();
    }


    public TeacherRating getTeacherRatingById(TeacherRatingId id) {
        return teacherRatingRepository.findById(id).orElse(null);
    }

    public String deleteTeacherRatingById(TeacherRatingId id) {
        teacherRatingRepository.deleteById(id);
        return "Teacher Rating deleted: " + id;
    }

    public void deleteTeacherRating(TeacherRating teacherRating) {
        teacherRatingRepository.delete(teacherRating);
    }

    public void deleteAllTeacherRatings() {
        teacherRatingRepository.deleteAll();
    }

    public TeacherRating editTeacherRating(TeacherRating teacherRating) {
        TeacherRating existingTeacherRating = teacherRatingRepository.findById(teacherRating.getTeacherRatingId()).orElse(null);
        existingTeacherRating.setRating(teacherRating.getRating());
        return teacherRatingRepository.save(existingTeacherRating);
    }
}
