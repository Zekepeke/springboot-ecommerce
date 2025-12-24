package com.zekepeke.ecommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Representational State Transfer
@RestController
public class MessageController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
