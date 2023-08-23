package azizov.testproject.crud_mongodb.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactUpdateDTO {

    private String name;
    private String firstNumber;
    private String secondNumber;

}
