package victor.training.jpa.app.web.dto;

import victor.training.jpa.app.entity.Contact;

public class ContactDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String company;

    public ContactDto() {
    }

    public ContactDto(Long id, String firstName, String lastName, String company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }

    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.company = contact.getCompany();
    }
}
