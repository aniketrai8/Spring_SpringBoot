package com.example.bankts.service;
import com.example.bankts.model.Account;
import com.example.bankts.repository.AccountRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional

    public void transfer(Long fromId, Long toId, double amount) {

        Account from = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("From account not found"));

        Account to = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("To account not found"));

        if (from.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);



    }
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

}
