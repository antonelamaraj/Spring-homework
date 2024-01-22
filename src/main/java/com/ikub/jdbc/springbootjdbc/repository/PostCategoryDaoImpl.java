package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.PostCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostCategoryDaoImpl implements PostCategoryDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static String GET_POST_CATEGORIES_BY_POST_ID = "SELECT c.id, c.name, c.date_created, c.date_modified FROM categories c join Post_Categories pc ON c.id = pc.category_id WHERE pc.post_id=?";

    public static String GET_POST_CATEGORIES_BY_POST_ID_AND_CATEGORY_ID = "SELECT c.id, c.name, c.date_created, c.date_modified " +
            "FROM categories c join Post_Categories pc ON c.id = pc.category_id" +
            "WHERE pc.post_id=?&&pc.category_id=?";

    @Override
    public PostCategories getPostGategoryByPostId(Long postId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORIES_BY_POST_ID, new BeanPropertyRowMapper<>(PostCategories.class), postId);
    }

    @Override
    public PostCategories getPostCategoryByPostIdAndCategoryId(Long postId, Long categoryId) {
        return jdbcTemplate.queryForObject(GET_POST_CATEGORIES_BY_POST_ID_AND_CATEGORY_ID, new BeanPropertyRowMapper<>(PostCategories.class), postId, categoryId);
    }

}
