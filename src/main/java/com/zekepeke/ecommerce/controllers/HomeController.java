package com.zekepeke.ecommerce.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Marking this class as a bean
@Controller
public class HomeController {

    @RequestMapping("/")
    // Server side rendering
    public String index() {
        return "index.html";
    }





}
