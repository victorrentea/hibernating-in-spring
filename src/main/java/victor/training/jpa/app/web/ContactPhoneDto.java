package victor.training.jpa.app.web;

import victor.training.jpa.app.entity.Phone;

public class ContactPhoneDto {
    public String value;
    public Phone.Type type;

    public ContactPhoneDto() {
    }

    public ContactPhoneDto(Phone phone) {
        this.value = phone.getValue();
        this.type = phone.getType();
    }
}
