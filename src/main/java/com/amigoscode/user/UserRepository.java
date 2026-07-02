package com.amigoscode.user;

import java.util.List;

// TODO: 05 - Add @Repository annotation to this class

public class UserRepository {

    public List<String> findAllUsers() {
        return List.of("Alice", "Bob", "Charlie");
    }

}
