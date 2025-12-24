package com.zekepeke.ecommerce.controllers;

import com.zekepeke.ecommerce.entities.User;
import com.zekepeke.ecommerce.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    // Returning a list of all users
    @GetMapping("/users")
    // method: GET
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
