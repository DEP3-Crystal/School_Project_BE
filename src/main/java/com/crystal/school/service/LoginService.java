package com.crystal.school.service;

import com.crystal.school.model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final PasswordService passwordService = PasswordService.getInstance();

    public boolean validateUser(User user, String plainPassword) {
        return passwordService.doesPasswordMatches(plainPassword, user.getPassword(), user.getSalt());
    }
}
