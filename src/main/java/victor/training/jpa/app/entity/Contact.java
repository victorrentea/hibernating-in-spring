package victor.training.jpa.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import victor.training.jpa.app.common.MyTrackingEntityListener.Trackable;

@Data
@Entity
// TODO @EntityListeners( ...
// TODO implements Trackable
public class Contact implements Trackable {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName;
	private String lastName;
	private String company;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Phone> phones = new ArrayList<>();

	@LastModifiedDate // SOLUTION
	private LocalDateTime lastModifiedDate;

	@LastModifiedBy // SOLUTION
	private String lastModifiedBy;

	private Contact() { } // Hibernate

	public Contact(String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	public Contact addPhone(Phone phone) {
		phones.add(phone);
		phone.setContact(this);
		return this;
	}

	//	@PrePersist
//	@PreUpdate
//	public void automaticUpdateTrackingColumns() {
//		System.out.println("Before persist/update Subject");
//		lastModifiedDate = LocalDateTime.now();
//		lastModifiedBy = MyUtil.getUserOnCurrentThread();
//	}
}
	
