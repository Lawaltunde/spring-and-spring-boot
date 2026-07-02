package com.amigoscode.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // TODO: 02 - Add a private final GreetingService field
    //  Add a constructor that accepts GreetingService and assigns it to the field
    //  Then use greetingService.greet(name) in the greet() method below

    @GetMapping("/api/v1/greetings/{name}")
    public String greet(@PathVariable String name) {
        return "Hi, " + name + "!"; // Replace this with greetingService.greet(name)
    }

}
