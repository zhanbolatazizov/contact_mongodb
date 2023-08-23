package azizov.testproject.crud_mongodb.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "contacts")
@Getter
@Setter
public class Contact {

    @Id
    private String id;
    private String name;
    private String firstNumber;
    private String secondNumber;
    private Date createdDate;
}
