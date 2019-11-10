package victor.training.jpa.app.repo;

import lombok.Value;
import victor.training.jpa.app.entity.Contact;

import java.util.List;
public interface ContactRepoCustom {
	List<Contact> searchContact(ContactSearchCriteria criteria);
}
