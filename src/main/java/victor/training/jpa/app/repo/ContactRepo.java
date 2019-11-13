package victor.training.jpa.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.training.jpa.app.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {
}
