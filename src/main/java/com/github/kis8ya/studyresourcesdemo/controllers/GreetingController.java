package com.github.kis8ya.studyresourcesdemo.controllers;

import com.github.kis8ya.studyresourcesdemo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/greeting"})
public class GreetingController {

    private final Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }

    @GetMapping
    public String get() {
        return greeting.getMainPage();
    }

    @GetMapping({"/name"})
    public String getName() {
        return greeting.getName();
    }
}
