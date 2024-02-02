package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    List<Category> getCategoryById(Long id);
    Boolean createCategory(Category category);
    Boolean deleteCategoryById(Long categoryId);

}
