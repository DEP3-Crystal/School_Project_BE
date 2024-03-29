package com.crystal.school.model.pivote;


import com.crystal.school.model.Session;
import com.crystal.school.model.Student;
import com.crystal.school.model.id.SessionRatingId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session_ratings")
public class SessionRating {
    @EmbeddedId
    private SessionRatingId sessionRatingId;
    @Column(name = "rating")
    private Byte rating;
    @MapsId("student_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    @MapsId("session_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", insertable = false, updatable = false)
    private Session session;
}
