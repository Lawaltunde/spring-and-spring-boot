package com.amigoscode.user;

import java.util.List;

// TODO: 05 - Add @Service annotation to this class
//  Inject UserRepository via constructor injection
//  Use the injected repository in getAllUsers()

public class UserService {

    public List<String> getAllUsers() {
        return List.of(); // Replace with userRepository.findAllUsers()
    }

}
