package com.mainor.financetracker.Service;

import com.mainor.financetracker.dao.UserDAO;
import com.mainor.financetracker.entity.Account;
import com.mainor.financetracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO) {
        userDAO = theUserDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int theId) {
        return userDAO.findById(theId);
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userDAO.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        userDAO.deleteById(theId);
    }
}
