package com.deroahe.servicide.service_one.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldController {

    private static final Logger LOGGER = getLogger(HelloWorldController.class);

    private final WebClient client;

    public HelloWorldController(final WebClient.Builder builder) {
        this.client = builder
                .baseUrl("http://service-two/api")
                .filter(((request, next) -> {
                    LOGGER.info("Sending request with URL {}", request.url());
                    return next.exchange(request);
                }))
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
