package com.crystal.school.model.pivote;


import com.crystal.school.model.Teacher;
import com.crystal.school.model.User;
import com.crystal.school.model.id.TeacherRatingId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teacher_ratings")
public class TeacherRating {
    @EmbeddedId
    private TeacherRatingId teacherRatingId;
    @Column(name = "rating")
    private Byte rating;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable=false, updatable=false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable=false, updatable=false)
    private User student;

}
