package com.Aniket.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {

    @Autowired
    private Dog dog;

    @GetMapping("/ok")
    public String ok() {
        return dog.fun();

        /*@GetMapping("abc")
        public String sayHello() {
            return "Hello, this is  me Aniket";*/
        }
    }

