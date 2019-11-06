package victor.training.jpa.app.web;

import victor.training.jpa.app.entity.Contact;

public class ContactDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String company;

    public ContactDto() {
    }

    public ContactDto(Contact contact) {
        this.id = contact.getId();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.company = contact.getCompany();
    }
}
