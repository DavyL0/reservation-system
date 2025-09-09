package com.davy.reservation_system.user_service.service;

import com.davy.reservation_system.user_service.DTO.LoginDTO;
import com.davy.reservation_system.user_service.config.JwtUtil;
import com.davy.reservation_system.user_service.entities.User;
import com.davy.reservation_system.user_service.producer.UserProducer;
import com.davy.reservation_system.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {



    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UserProducer userProducer;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        userProducer.sendUserCreated(savedUser);
        return savedUser;
    }

    public String login(LoginDTO  loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("Username not found"));

        if(passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return jwtUtil.generateToken(user);
        }else {
            throw new RuntimeException("Wrong password");
        }

    }
}
