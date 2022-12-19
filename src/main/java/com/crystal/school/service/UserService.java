package com.crystal.school.service;


import com.crystal.school.model.User;
import com.crystal.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final PasswordService passwordService = PasswordService.getInstance();

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User saveUser(User user) {
        String plainPassword = user.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.generateSecurePassword(plainPassword, saltValue);
        user.setSalt(saltValue);
        user.setPassword(securePassword);
        return userRepository.save(user);
    }

    public boolean loginUser(User dtoUser) {
        User user = getUserByEmail(dtoUser.getEmail());
        String plainPassword = dtoUser.getPassword();
        return passwordService.doesPasswordMatches(plainPassword, user.getPassword(), user.getSalt());
    }


    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "user deleted " + id;
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setBiography(user.getBiography());
        existingUser.setEmail(user.getEmail());
        existingUser.setGender(user.getGender());
        existingUser.setPassword(user.getPassword());
        existingUser.setSalt(user.getSalt());
        return userRepository.save(existingUser);
    }
}
