package com.zekepeke.ecommerce.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Marking this class as a bean
@Controller
public class HomeController {

    // Server side rendering
    // Model is a container for data
    // using it to pass data from controller to view in the MVC
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Zekepeke");
        return "index";
    }





}
