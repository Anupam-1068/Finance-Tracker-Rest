package com.mainor.financetracker.rest;

import com.mainor.financetracker.Service.CategoryService;
import com.mainor.financetracker.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {

    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService theCategoryService) {
        categoryService = theCategoryService;
    }

    // expose "/categories" and return a list of categories
    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("categories/{categoryId}")
    public Category getCategory(@PathVariable int categoryId) {
        Category theCategory = categoryService.findById(categoryId);

        if (theCategory == null) {
            throw new RuntimeException("Category id not found - " + categoryId);
        }

        return theCategory;
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody Category theCategory) {
        theCategory.setId(null); // To force the creation of a new category
        Category dbCategory = categoryService.save(theCategory);
        return dbCategory;
    }

    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category theCategory) {
        Category dbCategory = categoryService.save(theCategory);
        return dbCategory;
    }

    @DeleteMapping("categories/{categoryId}")
    public String deleteCategory(@PathVariable int categoryId) {
        Category tempCategory = categoryService.findById(categoryId);

        if (tempCategory == null) {
            throw new RuntimeException("Category id not found - " + categoryId);
        }

        categoryService.deleteById(categoryId);
        return "Deleted category id - " + categoryId;
    }
}
