package com.mainor.financetracker.Service;

import com.mainor.financetracker.entity.Account;
import com.mainor.financetracker.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();

    Transaction findById(int theId);

    Transaction save(Transaction theTransaction);

    void deleteById(int theId);
}

