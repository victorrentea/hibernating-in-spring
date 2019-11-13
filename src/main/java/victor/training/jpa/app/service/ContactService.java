package victor.training.jpa.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

