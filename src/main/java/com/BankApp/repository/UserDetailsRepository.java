package com.BankApp.repository;

import com.BankApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
    boolean existsByNin(String nin);

    Optional<User> findByNin(String nin);
}
