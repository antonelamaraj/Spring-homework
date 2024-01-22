package com.ikub.jdbc.springbootjdbc.service;

import com.ikub.jdbc.springbootjdbc.entity.Categories;
import com.ikub.jdbc.springbootjdbc.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Categories> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public Categories getCategoryById(Long id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public Boolean createCategory(Categories category) {
        return categoryDao.createCategory(category);
    }
}
