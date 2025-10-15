package com.example.contact_message_springboot_webapp.dao.contact;

//Interface for contact related tasks

import com.example.contact_message_springboot_webapp.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {

    public List<Contact> showAllContacts();
    public void addContact(Contact contact);
    public Optional<Contact> searchContact(String name);
    public String deleteContact(String number);


}
