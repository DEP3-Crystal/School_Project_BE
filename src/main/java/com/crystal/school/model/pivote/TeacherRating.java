package com.crystal.school.model.pivote;


import com.crystal.school.model.Teacher;
import com.crystal.school.model.User;
import com.crystal.school.model.id.TeacherRatingId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "teacher_ratings")
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRating {
    @EmbeddedId
    private TeacherRatingId teacherRatingId;
    @Column(name = "rating")
    private Byte rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private User student;

}
