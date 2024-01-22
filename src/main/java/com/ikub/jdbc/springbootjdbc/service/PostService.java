package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getPostsById(Long id);
    List<Post> getPostsByUserId(Long userId);
    Boolean createPost(Post post);
    Boolean updatePost(Long id, Post user);
}
