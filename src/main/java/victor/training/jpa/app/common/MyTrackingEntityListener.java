package victor.training.jpa.app.common;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class MyTrackingEntityListener {
	public interface Trackable {
		void setLastModifiedBy(String username);
		void setLastModifiedDate(LocalDateTime dateTime);
	}
	
	@PreUpdate
    @PrePersist
    public void setLastUpdate(Trackable trackable) {
//		log.debug("Updating tracking columns of: {}", trackable);
//		trackable.setLastModifiedDate(LocalDateTime.now());
//		trackable.setLastModifiedBy(MyUtil.getUserOnCurrentThread());
    }
}
