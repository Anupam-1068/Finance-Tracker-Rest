package com.mainor.financetracker.Service;

import com.mainor.financetracker.entity.Account;
import com.mainor.financetracker.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}

