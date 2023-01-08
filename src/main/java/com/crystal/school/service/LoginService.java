package com.crystal.school.service;

import com.crystal.school.model.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    PasswordService passwordService = PasswordService.getInstance();

    public boolean validateUser(User user, String password) {
        return passwordService.doesPasswordMatches(password, user.getPassword(), user.getSalt());
    }
}
