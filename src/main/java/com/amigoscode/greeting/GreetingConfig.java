package com.amigoscode.greeting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfig {

    @Bean("greetingMessage")
    public String greetingMessage() {
        return "Hello";
    }

}
