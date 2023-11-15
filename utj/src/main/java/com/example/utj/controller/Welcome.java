package com.example.utj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class Welcome {
    @GetMapping("/")
    public String checkHealth(){
        return "backend listo.";
    }
}
