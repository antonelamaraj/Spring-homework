package com.ikub.jdbc.springbootjdbc.service.impl;

import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.repository.PostDao;
import com.ikub.jdbc.springbootjdbc.entity.User;
import com.ikub.jdbc.springbootjdbc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> getPosts() {
        return postDao.getPosts();
    }

    @Override
    public Post getPostsById(Long id) {
        return postDao.getPostsById(id);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        return postDao.getPostsByUserId(userId);
    }

    @Override
    public Boolean createPost(Post post) {
        return postDao.createPost(post);
    }

    @Override
    public Boolean updatePost(Long id, Post post) {
        return postDao.updatePost(id, post);
    }
}
