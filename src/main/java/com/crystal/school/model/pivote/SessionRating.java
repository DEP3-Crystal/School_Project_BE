package com.crystal.school.model.pivote;


import com.crystal.school.model.Session;
import com.crystal.school.model.User;
import com.crystal.school.model.id.SessionRatingId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "session_ratings")
public class SessionRating {
    @EmbeddedId
    private SessionRatingId sessionRatingId;
    @Column(name = "rating")
    private Byte rating;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "session_id", insertable = false, updatable = false)
    private Session session;
}
