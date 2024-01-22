package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.PostCategories;

public interface PostCategoryService {
    PostCategories getPostGategoryByPostId(Long postId);
    PostCategories getPostCategoryByPostIdAndCategoryId(Long postId, Long
            categoryId);
}
