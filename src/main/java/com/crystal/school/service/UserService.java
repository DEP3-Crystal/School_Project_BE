package com.crystal.school.service;


import com.crystal.school.dto.UserDto;
import com.crystal.school.dto.UserLogin;
import com.crystal.school.dto.UserRegistration;
import com.crystal.school.exception.ItemNotFoundException;
import com.crystal.school.mapper.UserMapper;
import com.crystal.school.model.User;
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
        return UserMapper.Instance.toUserDto(userRepository.findById(id).orElseThrow(ItemNotFoundException::new));
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

    public UserDto createUser(UserRegistration userRegistration) {
        User user = getUser(userRegistration);
        userRepository.save(user);
        return UserMapper.Instance.toUserDto(userRepository.save(user));
    }

    private User getUser(UserRegistration userRegistration) {
        String plainPassword = userRegistration.getPassword();
        String saltValue = passwordService.getSaltValue(30);
        String securePassword = passwordService.encryptPassword(plainPassword, saltValue);

        userRegistration.setPassword(securePassword);
        User user = UserMapper.Instance.toUser(userRegistration);
        user.setSalt(saltValue);
        return user;
    }

    public UserDto loginUser(UserLogin dtoUser) throws ItemNotFoundException {
        var notFoundMessage = "password or email does not match";
        try {
            User user = getUserByEmail(dtoUser.getEmail());
            String plainPassword = dtoUser.getPassword();
            if (passwordService.doesPasswordMatches(plainPassword, user.getPassword(), user.getSalt())) {
                return UserMapper.Instance.toUserDto(user);
            }
            throw new ItemNotFoundException(notFoundMessage);
        } catch (EntityNotFoundException ignored) {
            throw new ItemNotFoundException(notFoundMessage);
        }
    }


    public String deleteUser(Integer id) {
        userRepository.deleteById(id);
        return "user deleted " + id;
    }

    public UserDto updateUser(UserRegistration userRegistration) {
        validateUser(userRegistration);
        User user = UserMapper.Instance.toUser(userRegistration);
        User save = userRepository.save(user);
        return UserMapper.Instance.toUserDto(save);
    }

    private void validateUser(UserRegistration userRegistration) {
        var user = userRepository.findById(userRegistration.getUserId());
        if (user.isEmpty()) throw new ItemNotFoundException("User not found!");
    }

    public Boolean isEmployee(int userId) {
        return userRepository.isEmployee(userId);
    }
}
