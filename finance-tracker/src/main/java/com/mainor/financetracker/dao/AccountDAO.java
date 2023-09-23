package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAll();

    Account findById(int theId);

    Account save(Account theAccount);

    void deleteById(int theId);


}
