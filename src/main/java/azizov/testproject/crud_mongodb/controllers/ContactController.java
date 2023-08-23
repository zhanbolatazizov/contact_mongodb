package azizov.testproject.crud_mongodb.controllers;

import azizov.testproject.crud_mongodb.dtos.ContactDTO;
import azizov.testproject.crud_mongodb.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactDTO createContact(@RequestBody ContactDTO contactDTO) {
        return contactService.createContact(contactDTO);
    }

    @GetMapping("/{id}")
    public ContactDTO getContactById(@PathVariable String id) {
        return contactService.getContactById(id);
    }

    @GetMapping("/number/{number}")
    public ContactDTO getContactByNumber(@PathVariable String number) {
        return contactService.getContactByNumber(number);
    }

    @PutMapping("/{id}")
    public ContactDTO updateContact(@PathVariable String id, @RequestBody ContactDTO contactDTO) {
        return contactService.updateContact(id, contactDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteContactById(@PathVariable String id) {
        return contactService.deleteContactById(id);
    }

    @DeleteMapping("/number/{number}")
    public boolean deleteContactByNumber(@PathVariable String number) {
        return contactService.deleteContactByNumber(number);
    }
}
