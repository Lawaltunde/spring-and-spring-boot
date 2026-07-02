package com.amigoscode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Map;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> orderRoutes() {
        return RouterFunctions.route()
                .GET("/api/v1/orders/summary", request ->
                        ServerResponse.ok().body(Map.of(
                                "totalOrders", 42,
                                "pendingOrders", 5
                        )))
                .build();
    }

}
