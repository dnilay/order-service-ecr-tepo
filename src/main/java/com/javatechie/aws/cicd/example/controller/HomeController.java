package com.javatechie.aws.cicd.example.controller;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {
    private  final Environment environment;


    @GetMapping("/")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok().body("service is up. "+environment.getProperty("local.server.port"));
    }
}
