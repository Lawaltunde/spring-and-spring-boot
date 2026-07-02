package com.amigoscode.post;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postClient.getPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postClient.getPostById(id);
    }

}
