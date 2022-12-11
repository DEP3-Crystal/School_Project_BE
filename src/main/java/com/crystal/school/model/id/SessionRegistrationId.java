package com.crystal.school.model.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class SessionRegistrationId implements Serializable {
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "classroom_id")
    private Integer classroomId;
}
