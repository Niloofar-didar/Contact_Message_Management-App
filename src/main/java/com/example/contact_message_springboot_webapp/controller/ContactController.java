package com.example.contact_message_springboot_webapp.controller;

import com.example.contact_message_springboot_webapp.model.Contact;
import com.example.contact_message_springboot_webapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }



    @GetMapping("/getContacts")
    public List<Contact> showContacts(){

        return contactService.showAllContacts();
    }

    @PostMapping("/add")
    public void addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
    }

    /*
    This is to return contact if it's found with code 200, otherwise a message.
    That's why we define a ResponseEntity type for the API output

    * */
    @GetMapping("/search/{name}")
    public ResponseEntity<?> showContact(@PathVariable String name){

        Optional<Contact> contact= contactService.searchContact(name);
        return contact !=null? ResponseEntity.ok(contact) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact with name '"+ name+ "' not found");
    }

    @DeleteMapping("delete/{name}")
    public String deleteContact(@PathVariable String name){
        return contactService.deleteContact(name);
    }
}
