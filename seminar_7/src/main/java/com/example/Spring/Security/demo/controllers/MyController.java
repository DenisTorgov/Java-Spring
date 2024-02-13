package com.example.Spring.Security.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String login() {
        return "login.html";
    }
    @GetMapping("/public-data")
    public String publicData() {
        return "This is public data!";
    }

    @GetMapping("/private-data")
    public String privateData() {
        return "This is PRIVATE DATA!!!";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "Access Denied";
    }
}
