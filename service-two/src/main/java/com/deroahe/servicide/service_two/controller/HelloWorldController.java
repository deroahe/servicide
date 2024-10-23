package com.deroahe.servicide.service_two.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldController {

    @GetMapping
    public Mono<String> returnHelloWorld() {
        return Mono.just("Hello World from Service Two");
    }
}
