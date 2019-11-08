package victor.training.jpa.app.common;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import victor.training.jpa.app.service.ChangeLogService;

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
