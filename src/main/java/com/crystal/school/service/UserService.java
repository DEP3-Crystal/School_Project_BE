package com.crystal.school.service;


import com.crystal.school.dto.UserDto;
import com.crystal.school.exception.UserNotFoundException;
import com.crystal.school.mapper.UserMapper;
import com.crystal.school.model.User;
import com.crystal.school.model.UserLogin;
import com.crystal.school.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final PasswordService passwordService = PasswordService.getInstance();
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper.Instance::toUserDto).toList();
    }

    public UserDto getUserById(Integer id) {
        // TODO check null value
        return UserMapper.Instance.toUserDto(userRepository.findById(id).orElse(null));
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserDto getUserByEmailAndPassword(String email, String password) {
        return UserMapper.Instance.toUserDto(userRepository.findByEmailAndPassword(email, password));
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserDto saveUser(User user) {
        String plainPassword = user.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.generateSecurePassword(plainPassword, saltValue);
        user.setSalt(saltValue);
        user.setPassword(securePassword);
        return UserMapper.Instance.toUserDto(userRepository.save(user));
    }

    public UserDto loginUser(UserLogin dtoUser) throws UserNotFoundException {
        var notFoundMessage = "password or email does not match";
        try {

            User user = getUserByEmail(dtoUser.getEmail());
            String plainPassword = dtoUser.getPassword();
            if (passwordService.doesPasswordMatches(plainPassword, user.getPassword(), user.getSalt())) {
                return UserMapper.Instance.toUserDto(user);
            }
            throw new UserNotFoundException(notFoundMessage);
        } catch (EntityNotFoundException ignored) {
            throw new UserNotFoundException(notFoundMessage);
        }
    }


    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "user deleted " + id;
    }

    public UserDto updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setBiography(user.getBiography());
        existingUser.setEmail(user.getEmail());
        existingUser.setGender(user.getGender());
        existingUser.setPassword(user.getPassword());
        existingUser.setSalt(user.getSalt());
        return UserMapper.Instance.toUserDto(existingUser);
    }
}
