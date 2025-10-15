package com.example.contact_message_springboot_webapp.dao.contact;

/*This is the second implementation of contact dao class.
 that enables using mongo built-in  methods such as save()
but to use it, we need to annotate the model class with @Document so that spring knows
* */

import com.example.contact_message_springboot_webapp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Profile("mongo")
public class ContactMongoRepository implements ContactDao {


    @Autowired
    private MongoInterface mongoInterface;

    public ContactMongoRepository(MongoInterface mongoInterface) {
        this.mongoInterface = mongoInterface;
    }

    @Override
    public List<Contact> showAllContacts() {
        return mongoInterface.findAll();
    }

    @Override
    public void addContact(Contact contact) {
        mongoInterface.save(contact);

    }

    @Override
    public Optional<Contact> searchContact(String name) {

      return Optional.ofNullable(mongoInterface.findFirstByName(name).orElse(null));
    }

    @Override
    public String deleteContact(String number) {

       long deletedCount= mongoInterface.deleteByName(number);
       if(deletedCount>0){
           return "Contact deleted successfully";
       }
       return "Contact not found";

    }
}
