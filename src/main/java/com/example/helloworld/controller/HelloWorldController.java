package com.example.helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    private final Environment environment;

    public HelloWorldController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        String env = environment.getActiveProfiles()[0];
        logger.info("Received request to /hello endpoint in {} environment", env);
        return "Hello, World from " + env + "!";
    }
}