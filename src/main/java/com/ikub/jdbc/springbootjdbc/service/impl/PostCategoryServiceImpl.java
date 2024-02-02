package com.ikub.jdbc.springbootjdbc.service.impl;

import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.PostCategory;
import com.ikub.jdbc.springbootjdbc.repository.PostCategoryDao;
import com.ikub.jdbc.springbootjdbc.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {

   @Autowired
   private PostCategoryDao postCategoryDao;
    @Override
    public PostCategory getPostGategoryByPostId(Long postId) {
        return postCategoryDao.getPostGategoryByPostId(postId);
    }

    @Override
    public PostCategory getPostCategoryByPostIdAndCategoryId(Long postId, Long categoryId) {
        return postCategoryDao.getPostCategoryByPostIdAndCategoryId(postId, categoryId);
    }
}
