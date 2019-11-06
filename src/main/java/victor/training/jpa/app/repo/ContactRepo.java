package victor.training.jpa.app.repo;

import org.springframework.data.jpa.repository.Query;

import victor.training.jpa.app.common.EntityRepository;
import victor.training.jpa.app.entity.Contact;

public interface ContactRepo extends EntityRepository<Contact, Long>, ContactRepoCustom {

	@Query("SELECT c FROM Contact c WHERE UPPER(c.company) LIKE UPPER('%' || ?1 || '%')")
	Contact findByCompanyName(String companyNamePart);

	Contact findContactByFirstName(String firstName);

}
