package com.example.demo.service;

import com.example.demo.dto.request.AccountRequest;
import com.example.demo.dto.response.AccountResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {

    List<AccountResponse> getAllAccounts();

    ResponseEntity<?> getByAccountNo(Long accountNo);

    List<AccountResponse> saveAccount(List<AccountRequest> accountList);

    ResponseEntity<?> deleteByAccountNo(Long id);
}
