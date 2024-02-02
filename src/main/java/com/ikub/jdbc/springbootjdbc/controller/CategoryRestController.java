package com.ikub.jdbc.springbootjdbc.controller;

import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.service.CategoryService;
import com.ikub.jdbc.springbootjdbc.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<Category>> getPostCategories(){
        List<Category> listOfCategories = categoryService.getCategories();
        return new ResponseEntity<>(listOfCategories, HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<Category>> getCategoryById(@PathVariable Long categoryId){
        List<Category>  category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> addCategory(@RequestBody Category newCategory){
            newCategory.setId(0);
           boolean category = categoryService.createCategory(newCategory);
           return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("blog/categories/{categoryId}")
    public ResponseEntity<Boolean> deleteCategroyById(@PathVariable Long categoryId){
        boolean categoryDeleted= categoryService.deleteCategoryById(categoryId);
      return new ResponseEntity<>(categoryDeleted, HttpStatus.OK);
    }


}
