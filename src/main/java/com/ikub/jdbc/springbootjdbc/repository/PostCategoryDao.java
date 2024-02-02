package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.PostCategory;

public interface PostCategoryDao {

    PostCategory getPostGategoryByPostId(Long postId);
    PostCategory getPostCategoryByPostIdAndCategoryId(Long postId, Long
            categoryId);
}
