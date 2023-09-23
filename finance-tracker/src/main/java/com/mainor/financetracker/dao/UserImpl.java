package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.Category;
import com.mainor.financetracker.entity.Transaction;
import com.mainor.financetracker.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserImpl implements UserDAO{
    public EntityManager entityManager;

    @Autowired
    public UserImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<User> findAll() {
        // create a query
        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);

        // execute query and get result list
        List<User> users = theQuery.getResultList();

        // return the results
        return users;
    }

    @Override
    public User findById(int theId) {
        User user = entityManager.find(User.class,theId);
        return user;
    }

    @Override
    public User save(User theUser) {
        User user = entityManager.merge(theUser);
        return user;
    }

    @Override
    public void deleteById(int theId) {

        User user = entityManager.find(User.class,theId);
        entityManager.remove(user);
    }
}
