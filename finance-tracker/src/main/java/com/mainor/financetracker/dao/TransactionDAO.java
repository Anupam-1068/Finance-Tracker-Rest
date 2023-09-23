package com.mainor.financetracker.dao;

import com.mainor.financetracker.entity.Transaction;

import java.util.List;

public interface TransactionDAO {

    List<Transaction> findAll();

    Transaction findById(int theId);

    Transaction save(Transaction theTransaction);

    void deleteById(int theId);
}
