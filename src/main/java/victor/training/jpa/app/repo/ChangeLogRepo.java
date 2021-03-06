package victor.training.jpa.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import victor.training.jpa.app.entity.ChangeLog;
import victor.training.jpa.app.entity.Contact;

public interface ChangeLogRepo extends JpaRepository<ChangeLog, Long> {
}
