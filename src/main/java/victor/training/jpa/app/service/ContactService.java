package victor.training.jpa.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import victor.training.jpa.app.entity.ChangeLog;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.entity.Phone;
import victor.training.jpa.app.repo.ChangeLogRepo;
import victor.training.jpa.app.repo.ContactRepo;
import victor.training.jpa.app.repo.PhoneRepo;

@RequiredArgsConstructor
@Service
public class ContactService {
    private final PhoneRepo phoneRepo;
    private final ContactRepo contactRepo;
    private final ChangeLogRepo logRepo;

    @Transactional
    public void setCompany(long contactId, String company) {
        Contact contact = contactRepo.findById(contactId).get();
        logRepo.save(new ChangeLog("Update company of '" + contact.getFullName() + "' to: " + company));
        contact.setCompany(company);
    }

    public void addPhone(long contactId, String phoneValue, Phone.Type phoneType) {
        Contact contact = contactRepo.findById(contactId).get();
        logRepo.save(new ChangeLog("Added phone to '" + contact.getFullName() + "' : " + phoneValue));
        Phone phone = new Phone(phoneValue, phoneType);
        contact.addPhone(phone);
        phoneRepo.save(phone);
    }

}

