package com.example.contact_message_springboot_webapp.controller;

import com.example.contact_message_springboot_webapp.model.Message;
import com.example.contact_message_springboot_webapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController (MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/getAllMessages")
    public List<Message> getAllMessages() {
       return messageService.getAllMessages();
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody Message msg){
        messageService.sendMessage(msg);
        return ResponseEntity.status(HttpStatus.OK).body("Sent successfully!");
    }

    @GetMapping("/search/{id}")
    public Message findMessage(@PathVariable int id){
        return messageService.searchMessageById(id);
    }

}
