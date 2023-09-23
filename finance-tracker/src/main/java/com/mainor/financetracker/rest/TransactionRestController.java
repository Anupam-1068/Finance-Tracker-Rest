package com.mainor.financetracker.rest;

import com.mainor.financetracker.Service.TransactionService;
import com.mainor.financetracker.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionRestController {

    private TransactionService transactionService;

    @Autowired
    public TransactionRestController(TransactionService theTransactionService) {
        transactionService = theTransactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @GetMapping("transactions/{transactionId}")
    public Transaction getTransaction(@PathVariable int transactionId) {
        Transaction theTransaction = transactionService.findById(transactionId);

        if (theTransaction == null) {
            throw new RuntimeException("Transaction id not found - " + transactionId);
        }

        return theTransaction;
    }

    @PostMapping("transaction/")
    public Transaction addTransaction(@RequestBody Transaction theTransaction) {
        theTransaction.setId(null); // To force the creation of a new transaction
        Transaction dbTransaction = transactionService.save(theTransaction);
        return dbTransaction;
    }

    @PutMapping("transactions/")
    public Transaction updateTransaction(@RequestBody Transaction theTransaction) {
        Transaction dbTransaction = transactionService.save(theTransaction);
        return dbTransaction;
    }

    @DeleteMapping("transactions/{transactionId}")
    public String deleteTransaction(@PathVariable int transactionId) {
        Transaction tempTransaction = transactionService.findById(transactionId);

        if (tempTransaction == null) {
            throw new RuntimeException("Transaction id not found - " + transactionId);
        }

        transactionService.deleteById(transactionId);
        return "Deleted transaction id - " + transactionId;
    }
}
