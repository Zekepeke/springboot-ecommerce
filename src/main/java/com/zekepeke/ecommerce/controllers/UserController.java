package com.zekepeke.ecommerce.controllers;

import com.zekepeke.ecommerce.entities.User;
import com.zekepeke.ecommerce.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    // Returning a list of all users
    // no arguments since request mapping
    @GetMapping()
    // method: GET
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/names")
    public List<String> getAllNames() {
       return userRepository.findAllUsers();
    }

    @GetMapping("/emails")
    public List<String> getAllEmails() {
        return userRepository.findAllEmails();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
