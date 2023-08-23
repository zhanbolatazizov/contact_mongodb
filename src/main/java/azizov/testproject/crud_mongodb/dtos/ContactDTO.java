package azizov.testproject.crud_mongodb.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ContactDTO {

    private String id;
    private String name;
    private String firstNumber;
    private String secondNumber;
    private LocalDateTime createdDate;

}
