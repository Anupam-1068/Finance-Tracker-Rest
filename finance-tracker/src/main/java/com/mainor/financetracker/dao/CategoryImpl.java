package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryImpl implements CategoryDAO{
    public EntityManager entityManager;

    @Autowired
    public CategoryImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Category> findAll() {
        // create a query
        TypedQuery<Category> theQuery = entityManager.createQuery("from Category", Category.class);

        // execute query and get result list
        List<Category> categories = theQuery.getResultList();

        // return the results
        return categories;
    }

    @Override
    public Category findById(int theId) {
        Category category = entityManager.find(Category.class,theId);
        return category;
    }

    @Override
    public Category save(Category theCategory) {
        Category tempCategory = entityManager.merge(theCategory);
        return tempCategory;
    }

    @Override
    public void deleteById(int theId) {
        Category category = entityManager.find(Category.class,theId);
        entityManager.remove(category);
    }
}
