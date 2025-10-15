package com.example.contact_message_springboot_webapp.service;

import com.example.contact_message_springboot_webapp.dao.message.MessageDao;
import com.example.contact_message_springboot_webapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private final MessageDao messageDao;

    MessageService(@Qualifier("messageInMemRepository") MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public Message searchMessageById(int id) {
        return messageDao.searchMessageById(id);
    }

    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    public void sendMessage(Message message) {
        messageDao.sendMessage(message);
    }



}
