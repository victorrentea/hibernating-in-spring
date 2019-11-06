package victor.training.jpa.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.entity.Phone;
import victor.training.jpa.app.repo.ContactRepo;

@RequiredArgsConstructor
@Service
public class ContactService {
    private final ContactRepo repo;

    @Transactional
    public void addPhone(long contactId, String phoneValue, Phone.Type phoneType) {
        Contact contact = repo.findById(contactId).get();
        contact.addPhone(new Phone(phoneValue, phoneType));
    }
}
