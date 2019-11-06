package victor.training.jpa.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class Phone {
	public enum Type {
		PERSONAL, WORK, OFFICE
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String value;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@ManyToOne
	private Contact contact;

	private Phone() {	} // for Hibernate

	public Phone(String value, Type type) {
		this.value = value;
		this.type = type;
	}
}
