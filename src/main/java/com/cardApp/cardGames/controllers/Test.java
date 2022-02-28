package com.cardApp.cardGames.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/test")
    public String getString(){
        System.out.println("Test /test endpoint reached");
        return "Hello";
    }

    @GetMapping("/")
    public String get(){
        System.out.println("Test / endpoint reached");
        return "Test Endpoint Reached";
    }
}
