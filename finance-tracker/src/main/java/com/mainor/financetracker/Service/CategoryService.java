package com.mainor.financetracker.Service;

import com.mainor.financetracker.entity.Account;
import com.mainor.financetracker.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(int theId);

    Category save(Category theCategory);

    void deleteById(int theId);

}

