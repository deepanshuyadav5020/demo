package com.example.demo.serviceImpl;

import com.example.demo.dto.request.AccountRequest;
import com.example.demo.dto.request.ContactRequest;
import com.example.demo.dto.response.AccountResponse;
import com.example.demo.dto.response.ContactResponse;
import com.example.demo.models.Contact;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;


    public List<ContactResponse> getAllContacts(){
        List<Contact> contactList = contactRepository.findAll();

        List<ContactResponse> contactResponseList = new ArrayList<>();

        for(Contact contact : contactList){
            ContactResponse contactResponse = new ContactResponse();
            BeanUtils.copyProperties(contact,contactResponse);
            contactResponseList.add(contactResponse);
        }
        return contactResponseList;
    }

    public List<ContactResponse> saveContact(List<ContactRequest> requests){
        List<Contact> contactList = new ArrayList<>();
        for(ContactRequest contactRequest : requests){
            Contact contact = new Contact();
            BeanUtils.copyProperties(contactRequest, contact);
            Contact savedContactEntity = contactRepository.save(contact);
            contactList.add(savedContactEntity);
        }
        List<ContactResponse> contactListResponse = new ArrayList<>();

        for(Contact contact: contactList){
            ContactResponse contactResponse = new ContactResponse();
            BeanUtils.copyProperties(contact,contactResponse);
            contactListResponse.add(contactResponse);

        }
        return contactListResponse;
    }

    public ResponseEntity<?> getContactById(Long id){
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if(optionalContact.isPresent()){
            ContactResponse contactResponse = new ContactResponse();
            BeanUtils.copyProperties(optionalContact.get(),contactResponse);
            return ResponseEntity.status(HttpStatus.OK).body(contactResponse);
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Id id not present");
        }
    }
}
