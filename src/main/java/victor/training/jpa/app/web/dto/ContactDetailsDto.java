package victor.training.jpa.app.web.dto;

import victor.training.jpa.app.entity.Contact;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ContactDetailsDto {
    public String firstName;
    public String lastName;
    public String company;
    public List<ContactPhoneDto> phones = new ArrayList<>();

    public ContactDetailsDto() {
    }

    public ContactDetailsDto(Contact contact) {
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.company = contact.getCompany();
        this.phones = contact.getPhones().stream().map(ContactPhoneDto::new).collect(toList());
    }
}
