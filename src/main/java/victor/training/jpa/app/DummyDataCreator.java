package victor.training.jpa.app;

import static java.util.Arrays.asList;

import java.time.DayOfWeek;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.entity.Phone;
import victor.training.jpa.app.repo.ContactRepo;

@Slf4j
@RequiredArgsConstructor
@Component
public class DummyDataCreator {
	private final ContactRepo contactRepo;

	@Transactional
	public void persistDummyData() {
		log.info("Inserting dummy data");
		contactRepo.saveAll(asList(
			new Contact("Bruce", "Almighty", "Heaven Inc.")
				.addPhone(new Phone("0800HEAVEN", Phone.Type.OFFICE))
				.addPhone(new Phone("+777PRAYNOW", Phone.Type.WORK)),
			new Contact("Adam", "First", "Eden Ltd.")
				.addPhone(new Phone("0Eden", Phone.Type.OFFICE))
				.addPhone(new Phone("+4000000001", Phone.Type.PERSONAL))
		));

	}
}
