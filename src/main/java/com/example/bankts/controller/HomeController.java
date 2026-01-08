package com.example.bankts.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/bank")
    public String home(){
        return "Bank Application Running";
    }
}
