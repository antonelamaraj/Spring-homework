package com.ikub.jdbc.springbootjdbc.controller;

import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/posts")
public class PostRestController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{postId}/post")
    public ResponseEntity<Post> getPostById(@PathVariable long postId) {
        Post thePost = postService.getPostsById(postId);
        return new ResponseEntity<>(thePost, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId) {
        List<Post> thePost = postService.getPostsByUserId(userId);
        return thePost;
    }

    @PostMapping("/user")
    public ResponseEntity<Boolean> addPost(@RequestBody Post newPost){
            newPost.setId(0);
            boolean postCreated = postService.createPost(newPost);
            return new ResponseEntity<>(postCreated, HttpStatus.OK);
    }


}
