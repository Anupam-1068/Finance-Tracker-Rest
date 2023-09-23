package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}
