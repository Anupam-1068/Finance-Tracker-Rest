package com.mainor.financetracker.rest;

import com.mainor.financetracker.Service.AccountService;
import com.mainor.financetracker.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService theAccountService) {
        accountService = theAccountService;
    }

    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    // add mapping for GET /accounts/{accountid}

    @GetMapping("/accounts/{accountId}")
    public Account getEmployee(@PathVariable int accountId) {

        Account theAccount = accountService.findById(accountId);

        if (theAccount == null) {
            throw new RuntimeException("Account id not found - " + accountId);
        }

        return theAccount;
    }

    // add mapping for POST /account - add new account

    @PostMapping("/account")
    public Account addaccount(@RequestBody Account theAccount) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theAccount.setId(0L);

        Account dbAccount = accountService.save(theAccount);

        return dbAccount;
    }

    // add mapping for PUT /accounts - update existing account

    @PutMapping("/accounts")
    public Account updateAccount(@RequestBody Account theAccount) {

        Account dbAccount = accountService.save(theAccount);

        return dbAccount;
    }

    // add mapping for DELETE /accounts/{accountId} - delete account

    @DeleteMapping("/accounts/{accountId}")
    public String deleteAccount(@PathVariable int accountId) {

        Account tempAccount = accountService.findById(accountId);

        // throw exception if null

        if (tempAccount == null) {
            throw new RuntimeException("Account id not found - " + tempAccount);
        }

        accountService.deleteById(accountId);

        return "Deleted account id - " + accountId;
    }
}
