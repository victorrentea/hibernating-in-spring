package victor.training.jpa.app.common;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyTrackingEntityListener {
	public interface Traceable {
		void setLastModifiedBy(String username);
		void setLastModifiedDate(LocalDateTime dateTime);
	}
	
	@PreUpdate
    @PrePersist
    public void setLastUpdate(Traceable traceable) {
		log.debug("Updating tracking columns of: {}", traceable);
		traceable.setLastModifiedDate(LocalDateTime.now());
		traceable.setLastModifiedBy(GetCurrentUserUtil.getCurrentUser());
    }
}
