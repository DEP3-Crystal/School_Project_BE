package com.crystal.school.model.pivote;


import com.crystal.school.model.Teacher;
import com.crystal.school.model.User;
import com.crystal.school.model.id.TeacherRatingId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherRating {

    @EmbeddedId
    @NonNull
    private TeacherRatingId teacherRatingId;

    @Column(name = "rating")
    @Min(1)
    @Max(5)
    @NonNull
    private Byte rating;

    @Column(name = "comment")
    private String comment;
    @MapsId("teacherId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", insertable = false, updatable = false)
    private Teacher teacher;
    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private User student;

}
