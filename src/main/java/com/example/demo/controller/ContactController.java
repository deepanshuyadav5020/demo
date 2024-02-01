package com.example.demo.controller;

import com.example.demo.dto.request.ContactRequest;
import com.example.demo.dto.response.ContactResponse;
import com.example.demo.models.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping
    public List<ContactResponse> getAllContacts(){
        return contactService.getAllContacts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getContactById(@PathVariable Long id){
        return contactService.getContactById(id);
    }

    @PostMapping
    public List<ContactResponse> saveContact(@RequestBody List<ContactRequest> contactList){
        return contactService.saveContact(contactList);
    }
}
