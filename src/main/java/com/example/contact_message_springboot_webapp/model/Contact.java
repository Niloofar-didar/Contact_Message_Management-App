package com.example.contact_message_springboot_webapp.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

//use @Document annotation to tell spring that it's a mongo DB document to then use readytouse methods in repository class such as save()
//you don't need @document if you only use contactInmemRepository and wanna ignore M0ngo DB
@Document
public class Contact
{
    @Id
    private String id; //  Required for MongoDB to manage unique documents
    private String name;

    private String number;
    private String email;
    private ArrayList<Message> messages;

    public Contact() {
        this.messages = new ArrayList<>();
    }

    public Contact(ArrayList<Message> messages, String email, String number, String name) {
        this.messages = messages;
        this.email = email;
        this.number = number;
        this.name = name;
    }

    public Contact(String email, String number, String name) {
        this.email = email;
        this.number = number;

        this.name = name;
        this.messages = new ArrayList<>();
    }

    public void getDetails(){
        System.out.println("First Name: " + name +
                " \nNumber: " + number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }


}
