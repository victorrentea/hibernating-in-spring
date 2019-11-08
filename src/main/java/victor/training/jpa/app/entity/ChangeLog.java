package victor.training.jpa.app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ChangeLog {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    public ChangeLog(String message) {
        this.message = message;
    }
}
