package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.PostCategories;
import com.ikub.jdbc.springbootjdbc.repository.PostCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCategoryServiceImpl implements PostCategoryService{

   @Autowired
   private PostCategoryDao postCategoryDao;
    @Override
    public PostCategories getPostGategoryByPostId(Long postId) {
        return postCategoryDao.getPostGategoryByPostId(postId);
    }

    @Override
    public PostCategories getPostCategoryByPostIdAndCategoryId(Long postId, Long categoryId) {
        return postCategoryDao.getPostCategoryByPostIdAndCategoryId(postId, categoryId);
    }
}
