package azizov.testproject.crud_mongodb.services;

import azizov.testproject.crud_mongodb.dtos.ContactDTO;
import azizov.testproject.crud_mongodb.models.Contact;
import azizov.testproject.crud_mongodb.repositories.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDTO, contact);
        contact.setCreatedDate(new Date());
        Contact savedContact = contactRepository.save(contact);
        return contactDTO;
    }

    public ContactDTO getContactById(String id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        ContactDTO contactDTO = new ContactDTO();
        BeanUtils.copyProperties(contact, contactDTO);
        return contactDTO;
    }

    public ContactDTO getContactByNumber(String number) {
        Contact contact = contactRepository.findByFirstNumberOrSecondNumber(number, number);
        ContactDTO contactDTO = new ContactDTO();
        BeanUtils.copyProperties(contact, contactDTO);
        return contactDTO;
    }

    public ContactDTO updateContact(String id, ContactDTO contactDTO) {
        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact != null) {
            BeanUtils.copyProperties(contactDTO, existingContact);
            existingContact.setId(id);
            Contact updatedContact = contactRepository.save(existingContact);
            BeanUtils.copyProperties(updatedContact, contactDTO);
            return contactDTO;
        }
        return null;
    }

    public boolean deleteContactById(String id) {
        contactRepository.deleteById(id);
        return true;
    }

    public boolean deleteContactByNumber(String number) {
        Contact contact = contactRepository.findByFirstNumberOrSecondNumber(number, number);
        if (contact != null) {
            contactRepository.delete(contact);
            return true;
        }
        return false;
    }
}
