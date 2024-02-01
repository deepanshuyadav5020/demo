package com.example.demo.controller;

import com.example.demo.dto.request.AccountRequest;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/api/account")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountResponse> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/{accountNo}")
    public ResponseEntity<?> getByAccountNo(@PathVariable Long accountNo){
        return accountService.getByAccountNo(accountNo);
    }

    @PostMapping
    public List<AccountResponse> saveAccount(@RequestBody List<AccountRequest> accountList){
        return accountService.saveAccount(accountList);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long accountNo){
        return accountService.deleteByAccountNo(accountNo);
    }
}
