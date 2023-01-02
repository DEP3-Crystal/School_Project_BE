package com.crystal.school.model.pivote;


import com.crystal.school.model.Session;
import com.crystal.school.model.User;
import com.crystal.school.model.id.StudentGradeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "student_grades")
@AllArgsConstructor
@NoArgsConstructor
public class StudentGrade {
    @EmbeddedId
    private StudentGradeId studentGradeId;
    @Column(name = "grade")
    private Byte grade;

    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private User student;

    @MapsId("sessionId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", insertable = false, updatable = false)
    private Session session;

}
