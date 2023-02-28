package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {


    @GetMapping(path = "/hello")
    public String hello(@RequestParam(name = "message") String message) {
        return "Hello " + message;
    }


    @GetMapping(path = "/movie/{id}")
    public String getMovie(@PathVariable(name = "id") String id) {
        return "";
    }
}
