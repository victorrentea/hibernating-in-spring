package victor.training.jpa.app.repo;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import org.springframework.lang.NonNullApi;
import victor.training.jpa.app.common.EntityRepository;
import victor.training.jpa.app.entity.Contact;

import java.util.List;

public interface ContactRepo extends EntityRepository<Contact, Long>, ContactRepoCustom {

	List<Contact> findContactByFirstNameIsLike(String firstName);

//	@Query("SELECT c FROM Contact c WHERE c.id = ?1")
//	@EntityGraph(attributePaths = {"phones","addresses"})
	Contact getById(long contactId);

	@Query("SELECT c FROM Contact c")
	List<ContactFirstAndLastName> findAllNames();

}
