package com.amigoscode.post;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class PostClient {

    private final RestClient restClient;

    public PostClient() {
        this.restClient = RestClient.create("https://jsonplaceholder.typicode.com");
    }

    public List<Post> getPosts() {
        return List.of(restClient.get()
                .uri("/posts")
                .retrieve()
                .body(Post[].class));
    }

    public Post getPostById(Long id) {
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }

}
