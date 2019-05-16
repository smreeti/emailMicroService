package com.smriti.emailscheduler.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
