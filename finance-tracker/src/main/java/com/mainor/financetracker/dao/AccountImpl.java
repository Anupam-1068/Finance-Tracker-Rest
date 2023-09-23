package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountImpl implements AccountDAO{

    public EntityManager entityManager;

    @Autowired
    public AccountImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Account> findAll() {
        // create a query
        TypedQuery<Account> theQuery = entityManager.createQuery("from Account", Account.class);

        // execute query and get result list
        List<Account> accounts = theQuery.getResultList();

        // return the results
        return accounts;
    }

    @Override
    public Account findById(int theId) {
        Account account = entityManager.find(Account.class,theId);
        return account;
    }

    @Override
    public Account save(Account theAccount) {
        Account tempAccount = entityManager.merge(theAccount);
        return tempAccount;
    }

    @Override
    public void deleteById(int theId) {

        Account account = entityManager.find(Account.class,theId);
        entityManager.remove(account);
    }
}
