package azizov.testproject.crud_mongodb.repositories;

import azizov.testproject.crud_mongodb.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String > {

    Contact findByFirstNumberOrSecondNumber(String firstNumber, String secondNumber);

}
