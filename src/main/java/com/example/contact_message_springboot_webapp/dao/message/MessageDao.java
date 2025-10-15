package com.example.contact_message_springboot_webapp.dao.message;

import com.example.contact_message_springboot_webapp.model.Message;

import java.util.List;

public interface MessageDao {

    public void sendMessage(Message message);
    public List<Message> getAllMessages();
    public Message searchMessageById(int id);
}
