package com.crystal.school.service;

import com.crystal.school.dto_old.pivote.TeacherRatingDto;
import com.crystal.school.mapper.TeacherRatingMapper;
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

    public TeacherRatingDto saveTeacherRating(TeacherRating teacherRating) {
        return TeacherRatingMapper.Instance.toTeacherRatingDto(teacherRatingRepository.save(teacherRating));
    }

    public List<TeacherRatingDto> saveTeacherRatings(List<TeacherRating> teacherRatings) {
        return teacherRatingRepository.saveAll(teacherRatings).stream().map(TeacherRatingMapper.Instance::toTeacherRatingDto).toList();
    }

    public List<TeacherRatingDto> getTeacherRatings() {
        return teacherRatingRepository.findAll().stream().map(TeacherRatingMapper.Instance::toTeacherRatingDto).toList();
    }


    public TeacherRatingDto getTeacherRatingById(TeacherRatingId id) {
        return TeacherRatingMapper.Instance.toTeacherRatingDto(teacherRatingRepository.findById(id).orElse(null));
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

    public TeacherRatingDto editTeacherRating(TeacherRating teacherRating) {
        TeacherRating existingTeacherRating = teacherRatingRepository.findById(teacherRating.getTeacherRatingId()).orElse(null);
        existingTeacherRating.setRating(teacherRating.getRating());
        return TeacherRatingMapper.Instance.toTeacherRatingDto(teacherRatingRepository.save(existingTeacherRating));
    }
}
