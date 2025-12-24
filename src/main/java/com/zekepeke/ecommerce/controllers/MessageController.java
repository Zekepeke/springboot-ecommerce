package com.zekepeke.ecommerce.controllers;

import com.zekepeke.ecommerce.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Representational State Transfer
@RestController
public class MessageController {
    @RequestMapping("/hello")
    public Message sayHello() {
        return new Message("Hello World!");
    }
}
