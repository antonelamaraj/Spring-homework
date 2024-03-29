package com.ikub.jdbc.springbootjdbc.repository.impl;

import com.ikub.jdbc.springbootjdbc.mapper.PostCategoryMapper;
import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.PostCategory;
import com.ikub.jdbc.springbootjdbc.repository.PostCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostCategoryDaoImpl implements PostCategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String GET_POST_CATEGORY_BY_POST_ID_Q = "SELECT * FROM post_categories pc JOIN posts p ON pc.post_id = p.id JOIN categories c ON pc.category_id = c.id WHERE post_id=?";
    private static final String GET_POST_CATEGORY_BY_POST_ID_AND_CATEGORY_ID_Q = "SELECT * FROM post_categories pc JOIN posts p ON pc.post_id = p.id JOIN categories c ON pc.category_id = c.id WHERE post_id=? AND category_id=?";

    @Override
    public PostCategory getPostGategoryByPostId(Long postId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORY_BY_POST_ID_Q, new PostCategoryMapper(), postId);
    }

    @Override
    public PostCategory getPostCategoryByPostIdAndCategoryId(Long postId, Long categoryId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORY_BY_POST_ID_AND_CATEGORY_ID_Q, new PostCategoryMapper(), postId, categoryId);
    }

}
