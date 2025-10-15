package com.example.contact_message_springboot_webapp.dao.message;

import com.example.contact_message_springboot_webapp.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageInMemRepository implements MessageDao {

    private final List<Message> messagesList = new ArrayList<Message>();

    @Override
    public List<Message> getAllMessages() {
        return messagesList;
    }

    @Override
    public Message searchMessageById(int id) {
       return messagesList.stream().filter(msg-> msg.getId() == id).findFirst().orElse(null);
    }


    @Override
    public void sendMessage(Message message) {

        messagesList.add(message);

    }

}
