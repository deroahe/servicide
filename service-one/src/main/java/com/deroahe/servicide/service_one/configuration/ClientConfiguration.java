package com.deroahe.servicide.service_one.configuration;

import org.slf4j.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.slf4j.LoggerFactory.getLogger;

@Configuration
public class ClientConfiguration {

    private static final Logger LOGGER = getLogger(ClientConfiguration.class);

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .filter(((request, next) -> {
                    LOGGER.info("{} request to '{}'", request.method(), request.url());
                    return next.exchange(request);
                }))
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add(CONTENT_TYPE, APPLICATION_JSON);
                    httpHeaders.add(ACCEPT, APPLICATION_JSON);
                });
    }
}
