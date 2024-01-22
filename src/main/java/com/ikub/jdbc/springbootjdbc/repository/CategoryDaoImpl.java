package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDaoImpl implements CategoryDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static String GET_AL_CATEGORIES = "SELECT * FROM CATEGORIES";
    public static String GET_CATEGORY_BY_ID = "SELECT * FROM CATEGORIES WHERE ID=?";
    public static String CREATE_NEW_CATEGORY = "INSERT INTO CATEGORIES(name, date_created, date_modified) values(?, ?, ?)";
    @Override
    public List<Categories> getCategories() {
        return jdbcTemplate.query(GET_AL_CATEGORIES, new BeanPropertyRowMapper<>(Categories.class));
    }

    @Override
    public Categories getCategoryById(Long id) {
        return jdbcTemplate.queryForObject(GET_CATEGORY_BY_ID, new BeanPropertyRowMapper<>(Categories.class), id);
    }

    @Override
    public Boolean createCategory(Categories category) {
        int categoryCreated = jdbcTemplate.update(CREATE_NEW_CATEGORY, new Object[]{
                       category.getName(), category.getDateCreated(), category.getDateModified()
        });
        return categoryCreated !=-1? true : false;
    }
}
