package com.example.demo.service;

import com.example.demo.dto.request.AccountRequest;
import com.example.demo.dto.request.ContactRequest;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.dto.response.ContactResponse;
import com.example.demo.models.Contact;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactService {
    public List<ContactResponse> getAllContacts();

    public List<ContactResponse> saveContact(List<ContactRequest> contactList);

    public ResponseEntity<?> getContactById(Long id);
}
