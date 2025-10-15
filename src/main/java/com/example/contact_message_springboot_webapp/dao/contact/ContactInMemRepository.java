package com.example.contact_message_springboot_webapp.dao.contact;

import com.example.contact_message_springboot_webapp.model.Contact;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("inmem")
public class ContactInMemRepository implements ContactDao {

    private final List<Contact> contactList = new ArrayList<Contact>();

    @Override
    public List<Contact> showAllContacts() {
        return contactList;
    }

    @Override
    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    @Override
    public Optional<Contact> searchContact(String fname ) {

       return Optional.ofNullable(contactList.stream().filter(c -> c.getName().equals(fname)).findFirst().orElse(null));
//                       && c.getLastName().equals(lname)) // if you wanna add  last name filter

    }

    @Override
    public String deleteContact(String number) {

        Optional<Contact> contact = searchContact(number);
        if(contact == null) {
            return "Contact not found";
        }
        contactList.remove(contact);
        return ("Deleted the contact "+ contact.get().getName() + " successfully");
    }
}
