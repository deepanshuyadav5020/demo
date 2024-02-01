package com.example.demo.serviceImpl;

import com.example.demo.dto.request.AccountRequest;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.models.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public List<AccountResponse> getAllAccounts() {
        List<Account> accountsList = accountRepository.findAll();

        List<AccountResponse> accountsListResponse = new ArrayList<>();

        for (Account account : accountsList) {
            AccountResponse accountResponse = new AccountResponse();
            BeanUtils.copyProperties(account, accountResponse);
            accountsListResponse.add(accountResponse);
        }

        return accountsListResponse;
    }

    public List<AccountResponse> saveAccount(List<AccountRequest> requests) {

        List<Account> accountsList = new ArrayList<>();
        for (AccountRequest accountRequest : requests) {
            Account account = new Account();
            BeanUtils.copyProperties(accountRequest, account);
            Account savedAccountEntity = accountRepository.save(account);
            accountsList.add(savedAccountEntity);
        }
        List<AccountResponse> accountsListResponse = new ArrayList<>();

        for (Account account : accountsList) {
            AccountResponse accountResponse = new AccountResponse();
            BeanUtils.copyProperties(account, accountResponse);
            accountsListResponse.add(accountResponse);
        }

        return accountsListResponse;
    }

    public ResponseEntity<?> getByAccountNo(Long accountNo) {
        Optional<Account> optionalAccount = accountRepository.findByAccountNo(accountNo);

        if (optionalAccount.isPresent()) {
            AccountResponse accountResponse = new AccountResponse();
            BeanUtils.copyProperties(optionalAccount.get(),accountResponse);
            return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
    public ResponseEntity<?> deleteByAccountNo(Long accountNo){
        Optional<Account> optionalAccount = accountRepository.findByAccountNo(accountNo);
        if (optionalAccount.isPresent()){
            accountRepository.delete(optionalAccount.get());
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Unable to delete");
        }

    }

}
