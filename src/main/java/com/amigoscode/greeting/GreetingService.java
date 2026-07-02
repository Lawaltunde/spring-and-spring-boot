package com.amigoscode.greeting;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    private final String greeting;

    public GreetingService(@Qualifier("greetingMessage") String greeting) {
        this.greeting = greeting;
    }

    public String greet(String name) {
        return greeting + ", " + name + "!";
    }

    @PostConstruct
    public void init() {
        System.out.println("GreetingService has been initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("GreetingService is being destroyed");
    }

}
