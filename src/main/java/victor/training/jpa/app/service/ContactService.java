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
//    private final PhoneRepo phoneRepo;
//    private final ContactRepo contactRepo;
//    private final ChangeLogRepo logRepo;

//    public void addPhone(long contactId, String phoneValue, Phone.Type phoneType) {
//        Contact contact = contactRepo.findById(contactId).get();
//        logRepo.save(new ChangeLog("Added phone to " + contact.getFullName()));
//        Phone phone = new Phone(phoneValue, phoneType);
//        contact.addPhone(phone);
//        phoneRepo.save(phone);
//    }
//
//    public void deleteContact(long id) {
//        logRepo.save(new ChangeLog("Deleted contact id:" + id));
//        Contact toDelete = contactRepo.findById(id).get();
//        contactRepo.delete(toDelete);
//    }
//
//    public void setCompany(long contactId, String company) {
//        Contact contact = contactRepo.findById(contactId).get();
//        logRepo.save(new ChangeLog("Update name of " + contact.getFullName()));
//        contact.setCompany(company);
//    }
}

