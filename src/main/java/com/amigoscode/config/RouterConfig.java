package com.amigoscode.config;

// TODO: 18 - Create a functional endpoint:
//  - Annotate this class with @Configuration
//  - Create a @Bean method that returns RouterFunction<ServerResponse>
//  - Define a GET route for "/api/v1/orders/summary"
//  - Return a JSON response with a Map containing:
//    "totalOrders" -> 42
//    "pendingOrders" -> 5
//  Example:
//    @Bean
//    public RouterFunction<ServerResponse> orderRoutes() {
//        return RouterFunctions.route()
//                .GET("/api/v1/orders/summary", request ->
//                        ServerResponse.ok().body(Map.of(
//                                "totalOrders", 42,
//                                "pendingOrders", 5
//                        )))
//                .build();
//    }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<?> routerFunction() {
        return RouterFunctions.route()
                .GET("/api/v1/orders/summary", request ->
                        ServerResponse.ok().body(
                                java.util.Map.of(
                                        "totalOrders", 42,
                                        "pendingOrders", 5
                                )
                        ))
                .build();
    }
}
