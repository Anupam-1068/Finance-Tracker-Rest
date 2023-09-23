package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.Category;
import com.mainor.financetracker.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionImpl implements TransactionDAO{
    public EntityManager entityManager;

    @Autowired
    public TransactionImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Transaction> findAll() {
        // create a query
        TypedQuery<Transaction> theQuery = entityManager.createQuery("from Transaction", Transaction.class);

        // execute query and get result list
        List<Transaction> transactions = theQuery.getResultList();

        // return the results
        return transactions;
    }

    @Override
    public Transaction findById(int theId) {
        Transaction transaction = entityManager.find(Transaction.class,theId);
        return transaction;
    }

    @Override
    public Transaction save(Transaction theTransaction) {
        Transaction transaction = entityManager.merge(theTransaction);
        return transaction;
    }

    @Override
    public void deleteById(int theId) {
        Transaction transaction = entityManager.find(Transaction.class,theId);
        entityManager.remove(transaction);

    }
}
