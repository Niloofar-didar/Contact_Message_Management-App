package com.example.contact_message_springboot_webapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String text;
    private String  recipient;
    private int id;


    public Message(int id, String recipient, String text) {
        this.id = id;
        this.recipient = recipient;
        this.text = text;
    }

}
