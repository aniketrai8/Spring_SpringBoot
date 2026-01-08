package com.example.bankts.controller;

import com.example.bankts.model.Account;
import com.example.bankts.service.AccountService;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.create(account);
    }

    @GetMapping
    public List<Account> all() {
        return accountService.getAll();
    }

    @PostMapping("/transfer")
    public String transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam double amount
    ) {
        accountService.transfer(fromId, toId, amount);
        return "Transfer successful";
    }

}
