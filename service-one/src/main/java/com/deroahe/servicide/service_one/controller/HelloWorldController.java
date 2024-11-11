package com.deroahe.servicide.service_one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private final WebClient client;

    public HelloWorldController(final WebClient.Builder builder) {
        this.client = builder
                .baseUrl("http://service-two")
                .build();
    }

    @GetMapping
    public Mono<String> returnHelloWorld() {
        return Mono.just("Hello World from Service One");
    }

    @GetMapping("/service-two")
    public Mono<String> callServiceTwo() {
        return client.get()
                .uri("/hello-world")
                .retrieve()
                .bodyToMono(String.class);
    }
}
