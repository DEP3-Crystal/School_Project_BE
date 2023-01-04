package com.crystal.school.service;

import com.crystal.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

//@Service
public class AuthenticationService {
//    @Autowired
//    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public String authenticate(String username, String password) {
//        Optional<User> user = userRepository.findByUsername(username);
//        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
//            return Jwts.builder()
//                    .setSubject(user.get().getUsername())
//                    .claim("roles", "user")
//                    .setIssuedAt(new Date())
//                    .signWith(SignatureAlgorithm.HS256, "secretkey")
//                    .compact();
//        }
//        throw new RuntimeException("Invalid credentials");
//    }
}
