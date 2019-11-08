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
    private final ContactRepo contactRepo;
    private final ChangeLogService logService;

    @Transactional
    public void setCompany(long contactId, String company) {
        Contact contact = contactRepo.findById(contactId).get();
        logService.addLog("Update name of " + contact.getFullName());
        contact.setCompany(company);
    }

    @Transactional
    public void addPhone(long contactId, String phoneValue, Phone.Type phoneType) {
        Contact contact = contactRepo.findById(contactId).get();
        contact.addPhone(new Phone(phoneValue, phoneType));
        logService.addLog("Added phone to " + contact.getFullName());
    }

    @Transactional
    public void deleteContact(long id) {
        logService.addLog("Deleted contact id:" + id);
        Contact toDelete = contactRepo.findById(id).get();
        contactRepo.delete(toDelete);
    }
}

