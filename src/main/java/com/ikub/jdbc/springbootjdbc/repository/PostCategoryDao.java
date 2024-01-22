package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.PostCategories;

public interface PostCategoryDao {

    PostCategories getPostGategoryByPostId(Long postId);
    PostCategories getPostCategoryByPostIdAndCategoryId(Long postId, Long
            categoryId);
}
