package com.zekepeke.ecommerce.controllers;

import com.zekepeke.ecommerce.dtos.RegisterUserRequest;
import com.zekepeke.ecommerce.dtos.UserDto;
import com.zekepeke.ecommerce.entities.User;
import com.zekepeke.ecommerce.mappers.UserMapper;
import com.zekepeke.ecommerce.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Returning a list of all users
    // no arguments since request mapping
    @GetMapping()
    // method: GET
    public List<UserDto> getAllUsers(
//            Use requestHeaders for any key value pairs as x-auth-token is a key with the value of 1234
//            @RequestHeader(name = "x-auth-token") String authToken
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort
    ) {
        if (!Set.of("name", "email").contains(sort)) {
            sort = "name";
        }

        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(user -> userMapper.toDto(user))
                .toList();
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
    // Using a ResponseEntity class to customize the response to return a 404
    // when valid long but wrong id
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);

        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }

//        return new ResponseEntity<>(user, HttpStatus.OK)
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    // Use the Request Body to get reuqest bodies like json, js, or html bodies from
    public ResponseEntity<UserDto> createUser(
            @RequestBody RegisterUserRequest userRequest,
            // used for a new location for a new usser
            UriComponentsBuilder uriBuilder
    ) {
        var user = userMapper.toEntity(userRequest);
        userRepository.save(user);

        var userDto = userMapper.toDto(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();

        return ResponseEntity.created(uri).body(userDto);
    }

}
