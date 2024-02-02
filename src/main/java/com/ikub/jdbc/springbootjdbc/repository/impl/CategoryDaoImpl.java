package com.ikub.jdbc.springbootjdbc.repository.impl;

import com.ikub.jdbc.springbootjdbc.exception.CategoryNotFoundException;
import com.ikub.jdbc.springbootjdbc.mapper.CategoryMapper;
import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String GET_CATEGORIES_Q = "SELECT * FROM categories";
    private static final String GET_CATEGORY_BY_ID_Q = "SELECT * FROM categories WHERE id=?";
    private static final String CREATE_CATEGORY_Q = "INSERT INTO categories(name,date_created) VALUES(?,?)";

    private static final String DELETE_CATEGORY  = "DELETE FROM CATEGORIES where id=?";
    @Override
    public List<Category> getCategories() {
        return jdbcTemplate.query(GET_CATEGORIES_Q, new CategoryMapper());
    }

    @Override
    public List<Category> getCategoryById(Long id) {
        try {
            return jdbcTemplate.query(GET_CATEGORY_BY_ID_Q, new CategoryMapper(), id);
        }catch (EmptyResultDataAccessException ex){
            throw new CategoryNotFoundException("Category with id: " + id + " is not found");
        }
    }

    @Override
    public Boolean createCategory(Category category) {
        var create = jdbcTemplate.update(CREATE_CATEGORY_Q, new Object[]{category.getName(), category.getDateCreated()});
        return create == -1 ? false : true;
    }

    @Override
    public Boolean deleteCategoryById(Long categoryId) {
        var delete = jdbcTemplate.update(DELETE_CATEGORY, new Object[]{categoryId});
        return delete == -1 ? false : true;
    }
}
