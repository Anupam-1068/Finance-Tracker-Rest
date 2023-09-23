package com.mainor.financetracker.Service;

import com.mainor.financetracker.dao.CategoryDAO;
import com.mainor.financetracker.entity.Account;
import com.mainor.financetracker.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO theCategoryDAO) {
        categoryDAO = theCategoryDAO;
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(int theId) {
        return categoryDAO.findById(theId);
    }

    @Transactional
    @Override
    public Category save(Category theCategory) {
        return categoryDAO.save(theCategory);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        categoryDAO.deleteById(theId);
    }
}
