package victor.training.jpa.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.entity.Phone;
import victor.training.jpa.app.entity.Tag;

import javax.persistence.EntityManager;

@Slf4j
@RequiredArgsConstructor
@Component
public class DummyDataCreator {
	private final EntityManager em;

	@Transactional
	public void persistDummyData() {
		log.info("Inserting dummy data");
		em.persist(
			new Contact("Bruce", "Almighty", "Heaven Inc.", Tag.WORK)
				.addPhone(new Phone("0800HEAVEN", Phone.Type.OFFICE))
				.addPhone(new Phone("+777PRAYNOW", Phone.Type.WORK))
		);
		em.persist(
			new Contact("Adam", "First", "Eden Ltd.", Tag.FAMILY)
				.addPhone(new Phone("0Eden", Phone.Type.OFFICE))
				.addPhone(new Phone("+4000000001", Phone.Type.PERSONAL))
		);

	}
}
