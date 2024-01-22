package com.ikub.jdbc.springbootjdbc.controller;

import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.Users;
import com.ikub.jdbc.springbootjdbc.service.PostService;
import com.ikub.jdbc.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public Users getUser(@PathVariable long userId) {
        Users theUser = userService.getUserById(userId);
        return theUser;
    }

    /*************Post*************************/
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getPosts();
    }

    @GetMapping("/posts/{postId}")
    public Post getPost(@PathVariable long postId) {
        Post thePost = postService.getPostsById(postId);
        return thePost;
    }

    @GetMapping("/postsOfUser/{userId}")
    public List<Post> getPosts(@PathVariable long userId) {
        List<Post> thePost = postService.getPostsByUserId(userId);
        return thePost;
    }



}
