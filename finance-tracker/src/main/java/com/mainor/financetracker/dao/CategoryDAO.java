package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> findAll();

    Category findById(int theId);

    Category save(Category theCategory);

    void deleteById(int theId);
}
