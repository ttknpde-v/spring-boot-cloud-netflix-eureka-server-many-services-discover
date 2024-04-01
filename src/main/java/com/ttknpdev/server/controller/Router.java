package com.ttknpdev.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Router {
    @GetMapping(value = "/eureka-netflix")
    private ResponseEntity<String> test() {
        return ResponseEntity.ok("You are on port 8761");
    }
}
