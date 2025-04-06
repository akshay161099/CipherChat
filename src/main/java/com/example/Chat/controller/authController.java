package com.example.Chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class authController {
    @GetMapping("/user")
    public String hello (Principal principal) {
         System.out.println("Hello "+principal.getName());
        return "Hello "+principal.getName();
    }
}
