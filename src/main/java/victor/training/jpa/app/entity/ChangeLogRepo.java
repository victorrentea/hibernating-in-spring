package victor.training.jpa.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeLogRepo extends JpaRepository<ChangeLog, Long> {
}
