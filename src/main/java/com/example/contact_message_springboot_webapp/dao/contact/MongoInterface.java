package com.example.contact_message_springboot_webapp.dao.contact;

import com.example.contact_message_springboot_webapp.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
/*
*You can compose any query name inside this interface and spring automatically creates the method
* without you needing to implement it. you only need to define method name based on below criteria:
[action][By][EntityField][Condition(optional)][And|Or][MoreFields...]
* examples:
*    findByFirstNameAndEmail(String firstName, String email)
    findByEmailOrNumber(String email, String number)
    deleteByEmailAndNumber(String email, String number)

 @@@@ Common supported actions (prefixes):@@@@
Prefix	example
findBy	findByEmail(String email)
readBy	readByNumber(String number)
getBy	getByFirstName(String name)
queryBy	queryByEmail(String email)
existsBy	existsByEmail(String email)
countBy	countByNumber(String number)
deleteBy	deleteByFirstName(String name)

*
* */
@Repository
public interface MongoInterface extends MongoRepository<Contact,String> {

    Optional<Contact> findFirstByName(String name);
    long deleteByName(String name);//deletes all matching records, defined long to get the count of deleted, if 1 means 1 record found, otherwise it was
    void deleteFirstByName(String name);// only deletes the first record that matches
}
