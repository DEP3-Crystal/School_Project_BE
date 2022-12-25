package com.crystal.school.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SessionRegistrationId implements Serializable {
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "room_id")
    private Integer roomId;
}
