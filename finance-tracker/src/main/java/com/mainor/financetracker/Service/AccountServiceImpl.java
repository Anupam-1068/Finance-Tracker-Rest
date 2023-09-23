package com.mainor.financetracker.Service;

import com.mainor.financetracker.dao.AccountDAO;
import com.mainor.financetracker.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO;

    @Autowired
    public AccountServiceImpl(AccountDAO theAccountDAO) {
        accountDAO = theAccountDAO;
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account findById(int theId) {
        return accountDAO.findById(theId);
    }

    @Transactional
    @Override
    public Account save(Account theAccount) {
        return accountDAO.save(theAccount);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        accountDAO.deleteById(theId);
    }
}
