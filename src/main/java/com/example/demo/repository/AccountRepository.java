package com.example.demo.repository;

import com.example.demo.models.Account;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE account_no = :accountNo")
    Optional<Account> findByAccountNo(Long accountNo);

    @Query(nativeQuery = true , value="DELETE FROM account WHERE ")
    Optional<Account> deleteBYAccountNo(Long accountNo);
}
