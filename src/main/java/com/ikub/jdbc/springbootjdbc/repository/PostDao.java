package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.User;

import java.util.List;

public interface PostDao {

    List<Post> getPosts();
    Post getPostsById(Long id);
    List<Post> getPostsByUserId(Long userId);
    Boolean createPost(Post post);
    Boolean updatePost(Long id, Post user);

}
