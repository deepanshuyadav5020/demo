package com.example.demo.repository;

import com.example.demo.models.Account;
import com.example.demo.models.Contact;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
//    @Query(nativeQuery = true, value= "SELECT * FROM contact WHERE id =:id")
//    Optional<Contact> findById(Long id);
}
