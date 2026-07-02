package com.amigoscode.user;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    public List<String> findAllUsers() {
        return List.of("Alice", "Bob", "Charlie");
    }

}
