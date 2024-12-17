package org.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping
    public String helloWorld() {
        return "Hello World";
    }
    @GetMapping("/name/{name}")
    public String helloWorld2(@PathVariable String name) {
        return "Hello " + name;
    }
    @GetMapping("/name")
    public String helloWorld3(String name, Integer age) {
        return "Hello " + name + " You're " + age;
    }
}
