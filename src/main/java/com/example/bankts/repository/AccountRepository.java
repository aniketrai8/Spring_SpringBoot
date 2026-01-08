package com.example.bankts.repository;
import com.example.bankts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;




public interface AccountRepository extends JpaRepository<Account, Long> {
}
