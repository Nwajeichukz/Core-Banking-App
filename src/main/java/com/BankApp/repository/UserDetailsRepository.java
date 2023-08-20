package com.BankApp.repository;

import com.BankApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
    boolean existsByNin(String nin);

    List<User> findByNinContaining(String nin);
    Optional<User> findByEmail(String email);

    Optional<User> findByNin(String nin);
}
