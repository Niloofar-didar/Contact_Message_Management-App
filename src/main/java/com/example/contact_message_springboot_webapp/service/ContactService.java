package com.example.contact_message_springboot_webapp.service;

import com.example.contact_message_springboot_webapp.dao.contact.ContactDao;
import com.example.contact_message_springboot_webapp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private final ContactDao contactDao;

    ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public List<Contact> showAllContacts() {
        return contactDao.showAllContacts();

    }

    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    public Optional<Contact> searchContact(String name) {
        return contactDao.searchContact(name);
    }

    public String  deleteContact(String number){
        return contactDao.deleteContact(number);
    }
}
