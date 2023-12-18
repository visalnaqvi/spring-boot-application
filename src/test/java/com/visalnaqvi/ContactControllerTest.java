package com.visalnaqvi;

import static org.mockito.Mockito.verify;
import com.visalnaqvi.controller.ContactController;
import com.visalnaqvi.modals.Contacts;
import com.visalnaqvi.repository.ContactsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ContactControllerTest {
    @Mock private ContactsRepository contactsRepository;

    private ContactController contactController;

    @BeforeEach void setUp()
    {
        this.contactController
                = new ContactController(this.contactsRepository);
    }

    @Test void getAllContacts()
    {
       contactController.getContacts();
        verify(contactsRepository).findAll();
    }

    @Test void newContact()
    {
        Contacts contact = new Contacts("name" , "address" , "1234567890" , "email@test.test");
        contactController.addContact(contact);
        verify(contactsRepository).save(contact);
    }

    }
