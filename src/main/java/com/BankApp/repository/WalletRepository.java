package com.BankApp.repository;

import com.BankApp.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    boolean existsByAccountNumber(String accountNumber);

}
