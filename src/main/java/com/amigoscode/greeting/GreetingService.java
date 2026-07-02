package com.amigoscode.greeting;

// TODO: 01 - Add @Component annotation to this class so Spring manages it as a bean

// TODO: 03 - Add @Qualifier("greetingMessage") to the constructor parameter

// TODO: 04 - Add @PostConstruct and @PreDestroy lifecycle hooks

public class GreetingService {

    private final String greeting;

    public GreetingService(String greeting) {
        this.greeting = greeting;
    }

    public String greet(String name) {
        return greeting + ", " + name + "!";
    }

}
