package victor.training.jpa.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import victor.training.jpa.app.entity.Contact;
import victor.training.jpa.app.web.dto.ContactSearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact, Long>, ContactRepoCustom {
    @Query("SELECT c FROM Contact c LEFT JOIN FETCH c.phones WHERE c.id = ?1")
    Optional<Contact> findWithPhones(long contactId);

    List<Contact> findByFirstNameLike(String firstName);


}
