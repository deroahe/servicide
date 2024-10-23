package com.deroahe.servicide.api_gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {

//    @Bean
//    public RouteLocator routes(final RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("api-gateway-route", r -> r.path("/api-gateway/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://api-gateway"))
//                .route("discovery-server-route", r -> r.path("/discovery-server/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://discovery-server"))
//                .route("service-one-route", r -> r.path("/service-one/**")
//                        .uri("lb://service-one"))
//                .route("service-two-route", r -> r.path("/service-two/**")
//                        .filters(f -> f.stripPrefix(1))
//                        .uri("lb://service-two"))
//                .build();
//    }
}
