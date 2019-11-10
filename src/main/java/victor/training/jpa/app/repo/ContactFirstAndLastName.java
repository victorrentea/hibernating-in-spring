package victor.training.jpa.app.repo;

import org.springframework.beans.factory.annotation.Value;

public interface ContactFirstAndLastName {
    String getFirstName();
    String getLastName();
    // TODO @Value(#{target
    // TODO using contactMapper bean, translate via message.properties
//    String getTags();
}
