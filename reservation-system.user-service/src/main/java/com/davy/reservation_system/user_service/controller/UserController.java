package com.davy.reservation_system.user_service.controller;
import com.davy.reservation_system.user_service.DTO.LoginDTO;
import com.davy.reservation_system.user_service.entities.User;
import com.davy.reservation_system.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService  userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return  userService.login(loginDTO);
    }
}
