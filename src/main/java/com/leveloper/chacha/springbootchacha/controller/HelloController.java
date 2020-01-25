package com.leveloper.chacha.springbootchacha.controller;

import com.leveloper.chacha.springbootchacha.aop.LogExecutionTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @LogExecutionTime
    public String hello(){
        return "hello";
    }
}
