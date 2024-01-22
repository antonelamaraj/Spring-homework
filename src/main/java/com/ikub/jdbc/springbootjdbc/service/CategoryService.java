package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.Categories;

import java.util.List;

public interface CategoryService {
    List<Categories> getCategories();
    Categories getCategoryById(Long id);
    Boolean createCategory(Categories category);
}
