package victor.training.jpa.app.entity;

import org.springframework.beans.factory.annotation.Value;

public interface ContactFirstAndLastName {
    String getFirstName();
    String getLastName();
//    @Value("#{target.tags.toString().toLowerCase()}")
    @Value("#{@contactMapper.translateTags(target.tags)}")
    String getTags();
}
