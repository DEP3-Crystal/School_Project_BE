package com.crystal.school.model;


import com.crystal.school.model.id.SessionRatingId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "session_rating")
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
