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

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }


    public User saveUser(User user) {
        return userRepository.save(user);
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
        existingUser.setStatus(user.getStatus());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }
}
