package com.example.studentdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
      return "Welcome to My StudentDataBase API with Search Feature enabled";
    }
}
