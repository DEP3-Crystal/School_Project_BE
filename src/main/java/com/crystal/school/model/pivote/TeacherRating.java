package com.crystal.school.model.pivote;


import com.crystal.school.model.Student;
import com.crystal.school.model.Teacher;
import com.crystal.school.model.id.TeacherRatingId;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="teacherRatings")
@Builder
public class TeacherRating {

    @EmbeddedId
    @NotNull
    private TeacherRatingId teacherRatingId;

    @Column(name = "rating")
    @Min(1)
    @Max(5)
    @NotNull
    private Byte rating;

    @Column(name = "comment")
    private String comment;
    @MapsId("teacher_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @MapsId("student_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

}
