package victor.training.jpa.app.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import victor.training.jpa.app.common.EntityRepository;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.entity.ContactFirstAndLastName;

import java.util.List;
import java.util.Optional;

public interface ContactRepo extends EntityRepository<Contact, Long>, ContactRepoCustom {

	@Query("SELECT c FROM Contact c WHERE UPPER(c.company) LIKE UPPER('%' || ?1 || '%')")
	Contact findByCompanyName(String companyNamePart);

	Contact findContactByFirstName(String firstName);

	@Query("SELECT c FROM Contact c")
	<T> List<T> findAll(Class<T> type);

	@Query("SELECT c FROM Contact c WHERE c.id = ?1")
	@EntityGraph(attributePaths = {"phones","addresses.streetName"})
	Optional<Contact> findWithPhones(long contactId);

}
