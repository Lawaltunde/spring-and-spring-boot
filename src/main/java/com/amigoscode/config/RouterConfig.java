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
public class RouterConfig {

}
