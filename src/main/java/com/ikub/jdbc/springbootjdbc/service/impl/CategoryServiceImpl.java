package com.ikub.jdbc.springbootjdbc.service.impl;

import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.repository.CategoryDao;
import com.ikub.jdbc.springbootjdbc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public List<Category> getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public Boolean createCategory(Category category) {
        return categoryDao.createCategory(category);
    }

    @Override
    public Boolean deleteCategoryById(Long categoryId) {
        return categoryDao.deleteCategoryById(categoryId);
    }
}
