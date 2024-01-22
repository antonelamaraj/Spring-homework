package com.ikub.jdbc.springbootjdbc.repository;

import com.ikub.jdbc.springbootjdbc.entity.Categories;

import java.util.List;

public interface CategoryDao {
    List<Categories> getCategories();
    Categories getCategoryById(Long id);
    Boolean createCategory(Categories category);

}
