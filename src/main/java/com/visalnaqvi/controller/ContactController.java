package com.visalnaqvi.controller;


import com.visalnaqvi.modals.Contacts;
import com.visalnaqvi.repository.ContactsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    private final ContactsRepository contactRepository;

    public ContactController(ContactsRepository contactRepository){

        this.contactRepository = contactRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Contacts>> getContacts(){
        try{
             List<Contacts> allContact = contactRepository.findAll();
            return new ResponseEntity<>(allContact, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/new")
    public ResponseEntity<String> addContact(@RequestBody Contacts contacts){
        try{
            Optional<Contacts> contact = contactRepository.findById(contacts.getPhoneNumber());
            if(contact.isPresent()){
                System.out.print("present");
                return new ResponseEntity<>("Already present", HttpStatus.INTERNAL_SERVER_ERROR);
            }else{
                Contacts createdContact =  contactRepository.save(contacts);
                return new ResponseEntity<>("created Successfully", HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable String id){
        try {
            Optional<Contacts> contact = contactRepository.findById(id);
            if(contact.isPresent()){
                contactRepository.deleteById(id);
                return new ResponseEntity<>("Successfully delete", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("cannot find the contact", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error while deleting the record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
