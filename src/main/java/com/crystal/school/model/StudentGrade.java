package com.crystal.school.model;


import com.crystal.school.model.id.StudentGradeId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_grade")
public class StudentGrade {
    @EmbeddedId
    private StudentGradeId studentGradeId;
    @Column(name = "grade")
    private Byte grade;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "session_id", insertable = false, updatable = false)
    private Session session;

}
