package com.mainor.financetracker.Service;

import com.mainor.financetracker.dao.TransactionDAO;
import com.mainor.financetracker.entity.Account;
import com.mainor.financetracker.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    private TransactionDAO transactionDAO;

    @Autowired
    public TransactionServiceImpl(TransactionDAO theTransactionDAO) {
        transactionDAO = theTransactionDAO;
    }

    @Override
    public List<Transaction> findAll() {
        return transactionDAO.findAll();
    }

    @Override
    public Transaction findById(int theId) {
        return transactionDAO.findById(theId);
    }

    @Transactional
    @Override
    public Transaction save(Transaction theTransaction) {
        return transactionDAO.save(theTransaction);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        transactionDAO.deleteById(theId);
    }
}
